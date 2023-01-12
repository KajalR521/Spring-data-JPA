package com.cg.rest.services;

import java.util.List;

import com.cg.rest.entity.Account;
import com.cg.rest.exception.NoSuchAccountFoundException;



public interface AccountServices {
	
	public Account addAccount(Account acc);

	public List<Account> findAllAccount();

	public Account findAccountById(int id) throws NoSuchAccountFoundException;

	public Account modifyAccount(Account acc, int id) throws NoSuchAccountFoundException;

	public boolean removeAccount(int id) throws NoSuchAccountFoundException;
	
	public List<Account> findAccByCustName(String custName);
}
