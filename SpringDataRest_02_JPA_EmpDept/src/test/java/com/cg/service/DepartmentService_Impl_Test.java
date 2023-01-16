package com.cg.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.rest.dao.DepartmentRepository;
import com.cg.rest.entity.Department;
import com.cg.rest.entity.Employee;
import com.cg.rest.exception.NoSuchDepartmentFoundException;
import com.cg.rest.exception.NoSuchEmployeeFoundException;
import com.cg.rest.services.DepartmentService_Impl;

@ExtendWith(MockitoExtension.class)
public class DepartmentService_Impl_Test {

	@Mock
	private DepartmentRepository dRepo;

	@InjectMocks
	private DepartmentService_Impl dService;

	private List<Department> dList;
	private Department dept = null;

	private DepartmentService_Impl_Test() {
		dService = new DepartmentService_Impl();
		dList = new ArrayList<>();

	}

	@Before
	private void initEach() {
		dept = new Department();
		dept.setDeptId(987);
		dept.setDeptName("Admin");

		Employee emp = new Employee();
		emp.setEmpId(123);
		emp.setEmpName("Test 1");
		emp.setEmpRole("Developer");
		emp.setEmpSalary(23445);

		dList.add(dept);
	}

	@Test
	void addDepartmentTest() {
		Mockito.when(dService.addDepartment(dept)).thenReturn(dept);
		assertEquals(dService.addDepartment(dept), dept);
		// Mockito.verify(dRepo,Mockito.times(1));
	}

	@Test
	void findAllDepartmentTest() {
		Mockito.when(dService.findAllDepartment()).thenReturn(dList);
		assertEquals(dService.findAllDepartment(), dList);
	}

	@Test
	void findDepartmentByEmpName() {
		Mockito.when(dService.findDeptByEmpName("Test 1")).thenReturn(dList);
		assertEquals(dService.findDeptByEmpName("Test 1"), dList);
	}

	@Test
	void findDeptById() {
		try {
			Mockito.when(dService.findDeaprtmentById(987)).thenReturn(dept);
			assertEquals(dService.findDeaprtmentById(987), dept);
		} catch (NoSuchDepartmentFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void updateDepartment() {
		try {
			Mockito.when(dService.modifyDepartment(dept, 987)).thenReturn(dept);
			assertEquals(dService.modifyDepartment(dept, 987), dept);
		} catch (NoSuchDepartmentFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void deleteDeaprtment() {
		boolean isDelete;
		try {
			isDelete = dService.removeDepartment(987);
			assertTrue(isDelete);
		} catch (NoSuchDepartmentFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

/*
 * Account acc = new Account();
 * 
 * acc.setAccNo(123456);
 * 
 * acc.setBankName("sbi");
 * 
 * acc.setAccBal(1000);
 * 
 * 
 * 
 * Employee emp = new Employee();
 * 
 * emp.setEid(1);
 * 
 * emp.setEname("kim");
 * 
 * emp.setEsal(19000);
 * 
 * emp.setEaccount(acc);
 * 
 * when(empRepo.findById(1)).thenReturn(Optional.of(emp));
 * 
 * assertEquals(eService.findEmpById(1), emp);
 * 
 * verify(empRepo, times(1)).findById(1);
 **/
