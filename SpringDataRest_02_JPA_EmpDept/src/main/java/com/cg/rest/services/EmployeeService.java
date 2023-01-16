package com.cg.rest.services;

import java.util.List;


import com.cg.rest.entity.Employee;
import com.cg.rest.exception.NoSuchEmployeeFoundException;


public interface EmployeeService {

	public Employee addEmployee(Employee emp);

	public List<Employee> findAllEmployee();

	public Employee findEmployeeById(int id) throws NoSuchEmployeeFoundException;

	public Employee modifyEmployee(Employee emp, int id) throws NoSuchEmployeeFoundException;

	public boolean removeEmployee(int id) throws NoSuchEmployeeFoundException;
	
	public List<Employee> findEmpByDept(String departmentName);
}
