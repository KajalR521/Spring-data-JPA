package com.cg.rest.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rest.dao.StudentRepository;
import com.cg.rest.entity.Course;
import com.cg.rest.entity.Student;
import com.cg.rest.exception.StudentNotFoundException;

@Service
public class StudentServices_Impl implements StudentServices {

	@Autowired
	private StudentRepository sRepo;

	@Override
	@Transactional
	public Student addStud(Student std) {

		return sRepo.save(std);
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		return sRepo.findAll();
	}

	@Override
	public Student findById(int id) throws StudentNotFoundException {
		Optional<Student> std = sRepo.findById(id);
		if (std.isPresent())
			return std.get();
		throw new StudentNotFoundException("No Student Available for this Id");
	}

	@Override
	@Transactional
	public Student updateStudentById(Student std, int id) throws StudentNotFoundException {
		Student findStd = findById(id);
		findStd.setsId(std.getsId());
		findStd.setsName(std.getsName());
		return sRepo.save(findStd);
	}




	@Override
	@Transactional
	public boolean deleteStudentById( int id) throws StudentNotFoundException {
		sRepo.deleteById(id);
		Optional<Student> sFind = sRepo.findById(id);
		if (sFind.isPresent()) {
			return false;
		}
		return true;
	}

}
