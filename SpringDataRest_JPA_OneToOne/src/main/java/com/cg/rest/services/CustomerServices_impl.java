package com.cg.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cg.rest.dao.CustomerRepository;

import com.cg.rest.entity.Customer;

import com.cg.rest.exception.NoSuchCustomerFoundException;

public class CustomerServices_impl implements CustomerServices {

	@Autowired
	private CustomerRepository cRepo;
	
	
	@Override
	@Transactional
	public Customer addCustomer(Customer cust) {
		return cRepo.save(cust);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return cRepo.findAll();
	}

	@Override
	public Customer findCustById(int id) throws NoSuchCustomerFoundException {
		Optional<Customer> cust=cRepo.findById(id);
		if(cust.isPresent()) 
			return cust.get();
		throw new NoSuchCustomerFoundException("Customer is Not available");
	}

	@Override
	@Transactional
	public Customer modifyCustomer(Customer cust, int id) throws NoSuchCustomerFoundException {
		Customer updateCust=findCustById(id);
		updateCust.setCustId(cust.getCustId());
		updateCust.setCustName(cust.getCustName());
		return cRepo.save(updateCust);
	}

	@Override
	@Transactional
	public boolean removeCustomer(int id) throws NoSuchCustomerFoundException {
		cRepo.deleteById(id);
		Optional<Customer> deleteCust=cRepo.findById(id);
		if(deleteCust.isPresent()) {
		return false;
		}
		return true;
	}

	@Override
	public List<Customer> findCustByAccId(int id) {
		return cRepo.findCustByAccId(id);
	}

}
