package com.cg.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.rest.dao.AccountRepository;
import com.cg.rest.entity.Account;
import com.cg.rest.exception.NoSuchAccountFoundException;

@Service
public class AccountServices_Impl implements AccountServices{
	
	@Autowired
	private AccountRepository accRepo;

	@Override
	@Transactional
	public Account addAccount(Account acc) {
		
		return accRepo.save(acc);
	}

	@Override
	public List<Account> findAllAccount() {
		
		return accRepo.findAll();
	}

	@Override
	public Account findAccountById(int id) throws NoSuchAccountFoundException {
	
		Optional<Account> acc=accRepo.findById(id);
		if(acc.isPresent()) 
			return acc.get();
		throw new NoSuchAccountFoundException("Account is Not available");
	}

	@Override
	@Transactional
	public Account modifyAccount(Account acc, int id) throws NoSuchAccountFoundException {
		Account accUpdate=findAccountById(id);
		accUpdate.setAccNo(acc.getAccNo());
		accUpdate.setAccType(acc.getAccType());
		accUpdate.setBankName(acc.getBankName());
		return accRepo.save(accUpdate);
	}

	@Override
	@Transactional
	public boolean removeAccount(int id) throws NoSuchAccountFoundException {
		accRepo.deleteById(id);
		Optional<Account> deleteAcc=accRepo.findById(id);
		if(deleteAcc.isPresent()) {
		return false;
		}
		return true;
		
	}

	@Override
	public List<Account> findAccByCustName(String custName) {
		return accRepo.findAccByCustName(custName);
	}

}
