package com.cg.rest.controllers;

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
import com.cg.rest.exception.NoSuchStudentFoundException;
import com.cg.rest.services.StudentService;

@RestController
public class StudentRestController {

	@Autowired
	private StudentService sService;

	// http://localhost:9090/StudentApp/students
	@GetMapping(path = "/stud")
	public ResponseEntity<List<Student>> getAllStudents() {
		try {
			List<Student> sList = sService.findAllStudents();
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
			Student stud = sService.createStudent(s1);
			return new ResponseEntity<>(stud, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/studbyid/{id}")
	public ResponseEntity<Student> getById(@PathVariable("id") int id) {
		try {

			return new ResponseEntity<>(sService.findStudentById(id), HttpStatus.OK);

		} catch (NoSuchStudentFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PutMapping("/updatestud/{id}")
	public ResponseEntity<Student> updateStud(@PathVariable("id") int id, @RequestBody Student student) {
		try {

			return new ResponseEntity<>(sService.updateStudent(id, student), HttpStatus.ACCEPTED);

		} catch (NoSuchStudentFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@DeleteMapping("/deletestud/{id}")
	public ResponseEntity<Student> deleteStud(@PathVariable("id") int id) {
		try {

			return new ResponseEntity<>(sService.deleteStudent(id), HttpStatus.OK);

		} catch (NoSuchStudentFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/studbymarks/{marks}")
	public ResponseEntity<Student> getByMarks(@PathVariable("marks") float marks) {
		try {
			List<Student> sList = sService.findByMarks(marks);
			if (sList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity(sService.findByMarks(marks), HttpStatus.OK);
			}

		} catch (NoSuchStudentFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
