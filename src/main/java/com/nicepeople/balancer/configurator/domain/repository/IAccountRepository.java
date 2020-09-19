package com.nicepeople.balancer.configurator.domain.repository;

import java.util.List;

import com.nicepeople.balancer.configurator.domain.model.Account;

public interface IAccountRepository {

	Account get(String accountCode);

	List<Account> getAll();

	Account save(Account account);
	
}
