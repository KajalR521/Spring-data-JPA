package com.cg.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.rest.entity.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	@Query("select e from Employee e join e.dept d where e.empName=:empName")
	List<Department> findDeptByEmpName(@Param("empName") String empName);
}
