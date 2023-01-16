package com.cg.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.cg.rest.dao.EmployeeRepository;
import com.cg.rest.entity.Department;
import com.cg.rest.entity.Employee;
import com.cg.rest.exception.NoSuchEmployeeFoundException;
import com.cg.rest.services.EmployeeService_Impl;

@ExtendWith(MockitoExtension.class)
public class EmployeeService_Impl_Test {

	@Mock
	private EmployeeRepository eRepo;

	@InjectMocks
	private EmployeeService_Impl eService;

	private List<Employee> eList;
	private Employee emp = null;

	private EmployeeService_Impl_Test() {
		eService = new EmployeeService_Impl();
		eList = new ArrayList<>();

	}

	@BeforeEach
	private void initEach() {
		emp = new Employee();
		emp.setEmpId(123);
		emp.setEmpName("Test");
		emp.setEmpRole("HR");
		emp.setEmpSalary(20000);

		Department dept = new Department();
		dept.setDeptId(987);
		dept.setDeptName("Admin");

		eList.add(emp);
	}

	@Test
	void addEmployeeTest() {
		Mockito.when(eService.addEmployee(emp)).thenReturn(emp);
		assertEquals(eService.addEmployee(emp), emp);
		verify(eRepo, Mockito.times(1)).save(emp);
	}

	@Test
	void findAllEmployeeTest() {
		Mockito.when(eService.findAllEmployee()).thenReturn(eList);
		assertEquals(eService.findAllEmployee(), eList);

	}

//	@Test
//	void findEmployeeByIdTest() {
//		try {
//			Optional<Employee> emplo=Optional.of(emp);
//			Mockito.when(eRepo.findEmpById(123)).thenReturn(emplo);
//			assertEquals( eService.findEmployeeById(123),emplo.get());
//		} catch (NoSuchEmployeeFoundException e) {
//			e.printStackTrace();
//			fail("No such Employee found exception");
//		}
//	}
	
	@Test
	void findEmployeeById() {
		try {
			Mockito.when(eService.findEmployeeById(123)).thenReturn(emp);
			assertEquals(eService.findEmployeeById(987), emp);
		} catch (NoSuchEmployeeFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Employee not found for this id");
			
		}
		
	}
	@Test
	void findEmployeeByDeptNameTest() {
		Mockito.when(eService.findEmpByDept("Admin")).thenReturn(eList);
		assertEquals(eService.findEmpByDept("Admin"), eList);
	}
	
	@Test
	void updateEmployeeTest() {
		try {
			Mockito.when(eService.modifyEmployee(emp, 123)).thenReturn(emp);
			assertEquals(eService.modifyEmployee(emp, 123),emp);
		} catch (NoSuchEmployeeFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No Employee Id is Found");
		}
		
	}
	
	@Test
	void deleteEmployeeTest() {
		boolean isDelete;
		try {
			isDelete = eService.removeEmployee(123);
			assertTrue(isDelete);
		} catch (NoSuchEmployeeFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can't able to delete employee");
		}
		
		
	}

}
