package com.cg.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.cg.rest.entity.Customer;
import com.cg.rest.exception.NoSuchCustomerFoundException;
import com.cg.rest.services.CustomerServices;



public class CustomerRestController {

	@Autowired
	private CustomerServices cServices;
	
	@PostMapping(path = "/newcust")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c1) {
		try {
			Customer cust =cServices.addCustomer(c1);
			return new ResponseEntity<>(cust, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	@GetMapping(path = "/allcustomer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		try {
			List<Customer> cList =cServices.findAllCustomer();
			if (cList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(cList, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/custbyid/{id}")
	public ResponseEntity<Customer> getCustById(@PathVariable("id") int id) {
		try {

			return new ResponseEntity(cServices.findCustById(id), HttpStatus.OK);

		} catch (NoSuchCustomerFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	

	@PutMapping("/modifycust/{id}")
	public ResponseEntity<Customer> modifyCust(@PathVariable("id") int id, @RequestBody Customer cust) {
		try {

			return new ResponseEntity<>(cServices.modifyCustomer(cust, id), HttpStatus.ACCEPTED);

		} catch (NoSuchCustomerFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@DeleteMapping("/removecust/{id}")
	public ResponseEntity<Customer> removeCust(@PathVariable("id") int id) {
		try {

			return new ResponseEntity(cServices.removeCustomer(id), HttpStatus.OK);

		} catch (NoSuchCustomerFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/custbyaccid/{id}")
	public ResponseEntity<Customer> findCustByAccId(@PathVariable("id") int id){
		List<Customer> cList=cServices.findCustByAccId(id);
		if(cList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity(cList,HttpStatus.NO_CONTENT);
		}
	}
	
}
