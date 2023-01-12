package com.cg.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.rest.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	@Query("select c from Customer c join c.account acc where c.custName=: custName")
	List<Account> findAccByCustName(@Param("custName") String custName);
}
