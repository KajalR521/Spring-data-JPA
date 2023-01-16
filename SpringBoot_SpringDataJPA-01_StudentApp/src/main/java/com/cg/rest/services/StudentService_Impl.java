package com.cg.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.rest.dao.StudentRepository;
import com.cg.rest.entity.Student;
import com.cg.rest.exception.NoSuchStudentFoundException;

@Service
public class StudentService_Impl implements StudentService {

	@Autowired
	private StudentRepository sRepo;

	@Override
	@Transactional
	public Student createStudent(Student s) {
		if (s.getsId() > 0) {
			sRepo.save(s);
			return s;
		}
		return null;
	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> sList = sRepo.findAll();
		return sList;
	}

	@Override
	public Student findStudentById(int id) throws NoSuchStudentFoundException {
		// Student s_find=sRepo.findById(id).get();
		Optional<Student> s_find = sRepo.findById(id);
		if (s_find.isPresent()) {
			return s_find.get();
		} else {
			throw new NoSuchStudentFoundException("Student Not Found");
		}

	}

	@Override
	@Transactional
	public Student updateStudent(int id, Student newStud) throws NoSuchStudentFoundException {
		Optional<Student> s_find = sRepo.findById(id);
		if (s_find.isPresent()) {
			return sRepo.save(newStud);
		} else {
			throw new NoSuchStudentFoundException("Student Not Found");
		}
	}

	@Override
	@Transactional
	public Student deleteStudent(int id) throws NoSuchStudentFoundException {
		Optional<Student> s_find = sRepo.findById(id);
		Student stud = null;
		if (s_find.isPresent()) {
			stud = s_find.get();
			sRepo.delete(stud);
		} else {
			throw new NoSuchStudentFoundException("Student Not Found");
		}
		return stud;

	}

	@Override
	public List<Student> findByMarks(float marks) {
		List<Student> s_find = sRepo.findByMarks(marks);
		return s_find; 
	}
	
	

}
