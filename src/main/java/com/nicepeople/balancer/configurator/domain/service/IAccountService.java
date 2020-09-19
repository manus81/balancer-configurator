package com.nicepeople.balancer.configurator.domain.service;

import java.util.List;

import com.nicepeople.balancer.configurator.domain.model.Account;

public interface IAccountService {

	public Account createAccount(Account account);

	public Account getAccount(String code);

	public List<Account> getAllAccounts();

	public Account updateAccount(Account account);

	public void deleteAccount(String code);
}
