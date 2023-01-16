package com.cg.rest.services;

import java.util.List;

import com.cg.rest.entity.Department;

import com.cg.rest.exception.NoSuchDepartmentFoundException;


public interface DepartmentService {

	public Department addDepartment(Department dept);

	public List<Department> findAllDepartment();

	public Department findDeaprtmentById(int id) throws NoSuchDepartmentFoundException;

	public Department modifyDepartment(Department dept, int id) throws NoSuchDepartmentFoundException;

	public boolean removeDepartment(int id) throws NoSuchDepartmentFoundException;
	
	public List<Department> findDeptByEmpName(String employeeName);
}
