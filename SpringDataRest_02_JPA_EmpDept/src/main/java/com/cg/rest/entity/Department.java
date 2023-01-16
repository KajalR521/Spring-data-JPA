package com.cg.rest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dept_table1")
public class Department {

	@Id
	private int deptId;
	private String deptName;

	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Employee> eList;


	
	public Department(List<Employee> eList) {
		super();
		this.eList = eList;
		for (Employee e : eList) {
			e.setDept(this);
		}
	}

	public Department() {
	}

	public Department(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}

}
