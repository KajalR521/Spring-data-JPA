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

import com.cg.rest.entity.Account;
import com.cg.rest.exception.NoSuchAccountFoundException;
import com.cg.rest.services.AccountServices;


public class AccountRestController {
	@Autowired
	private AccountServices aService;
	
	@PostMapping(path = "/newacc")
	public ResponseEntity<Account> addAccount(@RequestBody Account a1) {
		try {
			Account acc =aService.addAccount(a1);
			return new ResponseEntity<>(acc, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	@GetMapping(path = "/account")
	public ResponseEntity<List<Account>> getAllAccount() {
		try {
			List<Account> aList =aService.findAllAccount();
			if (aList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(aList, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/deptbyid/{id}")
	public ResponseEntity<Account> getAccById(@PathVariable("id") int id) {
		try {

			return new ResponseEntity<>(aService.findAccountById(id), HttpStatus.OK);

		} catch (NoSuchAccountFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	

	@PutMapping("/modifyacc/{id}")
	public ResponseEntity<Account> modifyAcc(@PathVariable("id") int id, @RequestBody Account acc) {
		try {

			return new ResponseEntity<>(aService.modifyAccount(acc, id), HttpStatus.ACCEPTED);

		} catch (NoSuchAccountFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@DeleteMapping("/removeAcc/{id}")
	public ResponseEntity<Account> removeAcc(@PathVariable("id") int id) {
		try {

			return new ResponseEntity(aService.removeAccount(id), HttpStatus.OK);

		} catch (NoSuchAccountFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/accbycustname/{custName}")
	public ResponseEntity<Account> findbyCustName(@PathVariable("custName") String custName){
		List<Account> aList=aService.findAccByCustName(custName);
		if(aList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity(aList,HttpStatus.NO_CONTENT);
		}
	}
	
	

}
