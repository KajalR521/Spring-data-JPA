package com.cg.rest.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class TrainerDTO {

	private int tId;

	// @Min or
	// @Max annotation is used to limit the value of a field.
	// In the below code, the tName field can have the maximum value of 5.
	@NotNull(message = "First Name Required")
	// @Min(value = 3, message = "First Name should have atleast 3 characters")
	@Size(min = 3, message = "First Name should have atleast 3 characters")
	private String firstName;

	@NotNull(message = "Last Name is required")
	@Size(min = 2, message = "Last name is required at least 2 letters")
	private String lastName;

	@NotEmpty
	@Email(message = "wrong email")
	private String email;

	@Past
	private LocalDate joiningDate;

	/*
	 * @Size annotation is used to restrict the filed length to a specified value.
	 * It has attributes such as max and min which are used to set the maximum and
	 * minimum values respectively. The message attribute in this annotation is used
	 * to display a default message on validation failure.
	 */

	@NotNull
	@Size(min = 3, message = "Company name should have min 3 characters required")
	private String compName;

	@NotNull
	private String subject;

	public TrainerDTO(int tId, String firstName, String lastName, String email, String compName, String subject,
			LocalDate joiningDate) {
		super();
		this.tId = tId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.compName = compName;
		this.subject = subject;
		this.joiningDate = joiningDate;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public TrainerDTO() {
	}

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
