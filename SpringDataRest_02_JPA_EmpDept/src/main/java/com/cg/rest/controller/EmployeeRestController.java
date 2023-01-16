package com.cg.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.entity.Employee;

import com.cg.rest.exception.NoSuchEmployeeFoundException;

import com.cg.rest.services.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService empService;
	
	@PostMapping(path = "/newemp")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e1) {
		try {
			Employee emp = empService.addEmployee(e1);
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	@GetMapping(path = "/emp")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		try {
			List<Employee> empList = empService.findAllEmployee();
			if (empList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(empList, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/empbyid/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") int id) {
		try {

			return new ResponseEntity<>(empService.findEmployeeById(id), HttpStatus.OK);

		} catch (NoSuchEmployeeFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	

	@PutMapping("/modifyemp/{id}")
	public ResponseEntity<Employee> modifyEmp(@PathVariable("id") int id, @RequestBody Employee emp) {
		try {

			return new ResponseEntity<>(empService.modifyEmployee(emp, id), HttpStatus.ACCEPTED);

		} catch (NoSuchEmployeeFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@DeleteMapping("/removeEmp/{id}")
	public ResponseEntity<Employee> removeEmp(@PathVariable("id") int id) {
		try {

			return new ResponseEntity(empService.removeEmployee(id), HttpStatus.OK);

		} catch (NoSuchEmployeeFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/empbydept/{deptName}")
	public ResponseEntity<Employee> findByDeptName(@PathVariable("deptName") String deptName){
		List<Employee> empList=empService.findEmpByDept(deptName);
		if(empList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity(empList,HttpStatus.NO_CONTENT);
		}
	}
	
	@ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "Student Not Found")
	@ExceptionHandler({Exception.class})
	public void handleConflict() {
		
	}
	
	
}
