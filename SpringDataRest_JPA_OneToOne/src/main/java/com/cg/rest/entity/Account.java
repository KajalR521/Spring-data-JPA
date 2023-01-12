package com.cg.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="acc_table1")
public class Account {
	
	@Id
	private int accNo;
	private String accType,bankName;
	
	@OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
	private Customer customer;
	public Account() {}

	public Account(int accNo, String accType, String bankName) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.bankName = bankName;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accType=" + accType + ", bankName=" + bankName + "]";
	}
	
	

}
