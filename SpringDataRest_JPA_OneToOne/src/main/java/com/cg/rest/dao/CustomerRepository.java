package com.cg.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.rest.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("Select a from Account a where a.accNo=:accNo")
	List<Customer> findCustByAccId(@Param("accNo") int accId);

}
