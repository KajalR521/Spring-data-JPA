package com.cg.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cust_table1")
public class Customer {
	
	@Id
	private int custId;
	private String custName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="FK_pno")
	private Account account;

	public Customer() {}
	
	public Customer(int custId, String custName, Account account) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.account = account;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", account=" + account + "]";
	}
	
	
}
