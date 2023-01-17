package com.cg.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.rest.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("Select s from Student s where s.sId=:sId")
	List<Student> findStudentById(@Param("sId") int sId);
	
	@Query("Select s from Student s where s.sName=:sName")
	List<Student > findByName(@Param("sName") String sName);
	
//	@Query("Select s from Student s join s.course c where c.cName=:cName")
//	List<Student > findByCourse(@Param("cName") String cName);

}
