package com.cg.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.rest.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e join e.dept d where d.deptName=:deptName")
	List<Employee> findEmpByDeptName(@Param("deptName") String deptName);

	@Query("select e from Employee  e where e.empId=:empId")
	List<Employee> findEmpById(@Param("empId") int empId);

}
