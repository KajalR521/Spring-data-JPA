package com.cg.rest.services;

import java.util.List;

import com.cg.rest.entity.Student;
import com.cg.rest.exception.NoSuchStudentFoundException;

public interface StudentService {
	
	public Student createStudent(Student s);
	public List<Student> findAllStudents();
	public Student findStudentById(int id) throws NoSuchStudentFoundException;
	public Student updateStudent(int id,Student newStud)throws NoSuchStudentFoundException;
	public Student deleteStudent(int id)throws NoSuchStudentFoundException;
	public List<Student> findByMarks(float marks)throws NoSuchStudentFoundException;
	

}
