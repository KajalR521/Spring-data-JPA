package com.cg.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course_Table01")
public class Course {

	@Id
	private int code;
	private String cName;


	public Course() {
	}


	public Course(int code, String cName) {
		super();
		this.code = code;
		this.cName = cName;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	@Override
	public String toString() {
		return "Course [code=" + code + ", cName=" + cName + "]";
	}


}
