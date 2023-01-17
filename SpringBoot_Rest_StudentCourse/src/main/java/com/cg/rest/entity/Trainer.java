package com.cg.rest.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Past;

@Entity
@Table(name = "Trainer_details")
public class Trainer {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;

	// create table Trainer_details(tid int primary key, fname varchar2(10)not
	// null,)

	private String firstName;

	private String lastName;

	// @Past and @Future are applied to Dates to make the sure
	// that the data is in past or future respectively.

	private LocalDate joiningDate;

	private String email;

	private String compName;

	private String subject;

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}