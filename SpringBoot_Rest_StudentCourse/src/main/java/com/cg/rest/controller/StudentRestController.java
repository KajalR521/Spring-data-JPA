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

import com.cg.rest.entity.Student;
import com.cg.rest.exception.StudentNotFoundException;
import com.cg.rest.services.StudentServices;

@RestController
public class StudentRestController {

	@Autowired
	private StudentServices service;
	
	// http://localhost:9090/StudentApp/student
		@GetMapping(path = "/stud")
		public ResponseEntity<List<Student>> getAllStudents() {
			try {
				List<Student> sList = service.getAllStudents();
				if (sList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				} else {
					return new ResponseEntity<>(sList, HttpStatus.OK);
				}
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

		@PostMapping(path = "/newstud")
		public ResponseEntity<Student> createStud(@RequestBody Student s1) {
			try {
				Student stud = service.addStud(s1);
				return new ResponseEntity<>(stud, HttpStatus.CREATED);
			} catch (Exception ex) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

			}

		}

		@GetMapping("/studbyid/{id}")
		public ResponseEntity<Student> getById(@PathVariable("id") int id) {
			try {

				return new ResponseEntity<>(service.findById(id), HttpStatus.OK);

			} catch (StudentNotFoundException e) {

				return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}

		@PutMapping("/updatestud/{id}")
		public ResponseEntity<Student> updateStud(@PathVariable("id") int id, @RequestBody Student student) {
			try {

				return new ResponseEntity<>(service.updateStudentById(student, id), HttpStatus.ACCEPTED);

			} catch (StudentNotFoundException e) {

				return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}

		@DeleteMapping("/deletestud/{id}")
		public ResponseEntity<Student> deleteStud(@PathVariable("id") int id) {
			try {

				return new ResponseEntity(service.deleteStudentById(id), HttpStatus.OK);

			} catch (StudentNotFoundException e) {

				return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}

}
