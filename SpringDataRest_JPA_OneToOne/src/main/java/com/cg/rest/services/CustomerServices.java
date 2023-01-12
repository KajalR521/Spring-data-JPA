package com.cg.rest.services;

import java.util.List;

import com.cg.rest.entity.Customer;
import com.cg.rest.exception.NoSuchCustomerFoundException;

public interface CustomerServices {

	public Customer addCustomer(Customer cust);

	public List<Customer> findAllCustomer();

	public Customer findCustById(int id) throws NoSuchCustomerFoundException;

	public Customer modifyCustomer(Customer cust, int id) throws NoSuchCustomerFoundException;

	public boolean removeCustomer(int id) throws NoSuchCustomerFoundException;
	
	public List<Customer> findCustByAccId(int id);
}
