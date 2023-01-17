package com.cg.rest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Student_Table01")
public class Student {

	@Id
	private int sId;
	private String sName;

	@Autowired
	@OneToMany(cascade = CascadeType.ALL)
	private List<Course> cList=new ArrayList<>();

	public Student() {
	}

	public Student(int sId, String sName, List<Course> cList) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.cList = cList;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public List<Course> getcList() {
		return cList;
	}

	public void setcList(List<Course> cList) {
		this.cList = cList;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", cList=" + cList + "]";
	}



}
