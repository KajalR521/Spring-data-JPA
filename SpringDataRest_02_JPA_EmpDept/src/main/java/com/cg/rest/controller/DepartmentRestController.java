package com.cg.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.entity.Department;
import com.cg.rest.exception.NoSuchDepartmentFoundException;
import com.cg.rest.services.DepartmentService;

@RestController
public class DepartmentRestController {
	
	@Autowired
	private DepartmentService dService;
	
	@PostMapping(path = "/newdept")
	public ResponseEntity<Department> addDeaprtment(@RequestBody Department d1) {
		try {
			Department dept = dService.addDepartment(d1);
			return new ResponseEntity<>(dept, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	@GetMapping(path = "/department")
	public ResponseEntity<List<Department>> getAllDepartment() {
		try {
			List<Department> dList = dService.findAllDepartment();
			if (dList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(dList, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/deptbyid/{id}")
	public ResponseEntity<Department> getDeptById(@PathVariable("id") int id) {
		try {

			return new ResponseEntity<>(dService.findDeaprtmentById(id), HttpStatus.OK);

		} catch (NoSuchDepartmentFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	

	@PutMapping("/modifydept/{id}")
	public ResponseEntity<Department> modifyDept(@PathVariable("id") int id, @RequestBody Department dept) {
		try {

			return new ResponseEntity<>(dService.modifyDepartment(dept, id), HttpStatus.ACCEPTED);

		} catch (NoSuchDepartmentFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@DeleteMapping("/removeDept/{id}")
	public ResponseEntity<Department> removeDept(@PathVariable("id") int id) {
		try {

			return new ResponseEntity(dService.removeDepartment(id), HttpStatus.OK);

		} catch (NoSuchDepartmentFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/deptbyemp/{empName}")
	public ResponseEntity<Department> findByEmpName(@PathVariable("empName") String empName){
		List<Department> dList=dService.findDeptByEmpName(empName);
		if(dList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity(dList,HttpStatus.NO_CONTENT);
		}
	}
	
	

}
