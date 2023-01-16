package com.cg.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.rest.dao.DepartmentRepository;
import com.cg.rest.entity.Department;

import com.cg.rest.exception.NoSuchDepartmentFoundException;

@Service
public class DepartmentService_Impl implements DepartmentService {

	@Autowired
	private DepartmentRepository deptRepo;
	
	@Override
	@Transactional
	public Department addDepartment(Department dept) {
		
		return deptRepo.save(dept);
	}

	@Override
	public List<Department> findAllDepartment() {
		
		return deptRepo.findAll();
	}

	@Override
	public Department findDeaprtmentById(int id) throws NoSuchDepartmentFoundException {
		Optional<Department> dept= deptRepo.findById(id);

		if (dept.isPresent())
			return dept.get();

		throw new NoSuchDepartmentFoundException("No Such Department");
	}

	@Override
	@Transactional
	public Department modifyDepartment(Department dept, int id) throws NoSuchDepartmentFoundException {
		Department updateDept=findDeaprtmentById(id);
		updateDept.setDeptId(dept.getDeptId());
		updateDept.setDeptName(dept.getDeptName());
		return deptRepo.save(updateDept);
	}

	@Override
	@Transactional
	public boolean removeDepartment(int id) throws NoSuchDepartmentFoundException {
		deptRepo.deleteById(id);
		Optional<Department> deleteDept=deptRepo.findById(id);
		if(deleteDept.isPresent()) {
		return false;
		}
		return true;
	}

	@Override
	public List<Department> findDeptByEmpName(String employeeName) {
		return deptRepo.findDeptByEmpName(employeeName);
	}



}
