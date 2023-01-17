package com.cg.rest.services;

import java.util.List;

import com.cg.rest.entity.Student;
import com.cg.rest.exception.StudentNotFoundException;

public interface StudentServices {
	
	public Student addStud(Student std);
	
	public List<Student> getAllStudents();
	
	public Student findById(int id) throws StudentNotFoundException;
	
	public Student updateStudentById(Student std,int id) throws StudentNotFoundException;
	
	public boolean deleteStudentById(int id) throws StudentNotFoundException;
	
	//public Student getAllCourse(Course course) throws StudentNotFoundException;
	
	

}
