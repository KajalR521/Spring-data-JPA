package com.cg.rest.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.rest.dao.StudentRepository;
import com.cg.rest.entity.Course;

import com.cg.rest.entity.Student;
import com.cg.rest.exception.StudentNotFoundException;
import com.cg.rest.services.StudentServices_Impl;

@ExtendWith(MockitoExtension.class)
public class StudentServicesImpl_Test {

	@Mock
	private StudentRepository sRepo;

	@InjectMocks
	private StudentServices_Impl service;

	private List<Student> list;
	private Student std = null;

	public StudentServicesImpl_Test() {
		service = new StudentServices_Impl();
		list = new ArrayList<>();
	}

	@BeforeEach
	private void initEach() {
		std = new Student();
		std.setsId(1);
		std.setsName("Kajal");

		Course c = new Course();
		c.setCode(987);
		c.setcName("Java");

		list.add(std);
	}

	@Test
	void addStudentTest() {
		Mockito.when(service.addStud(std)).thenReturn(std);
		assertEquals(service.addStud(std), std);
		verify(sRepo, Mockito.times(1)).save(std);
	}

	@Test
	void findAllStudentTest() {
		Mockito.when(service.getAllStudents()).thenReturn(list);
		assertEquals(service.getAllStudents(), list);

	}

	@Test
	void findStudentById() {
		try {
			Mockito.when(service.findById(1)).thenReturn(std);
			assertEquals(service.findById(1), std);
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Student not found for this id");

		}

	}

	@Test
	void updateStudentTest() {
		try {
			Mockito.when(service.updateStudentById(std, 1)).thenReturn(std);
			assertEquals(service.updateStudentById(std, 1), std);
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No Student Id is Found");
		}

	}

	@Test
	void deleteStudentTest() {
		boolean isDelete;
		try {
			isDelete = service.deleteStudentById(1);
			assertTrue(isDelete);
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can't able to delete Student");
		}

	}

}
