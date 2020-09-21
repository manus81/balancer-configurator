package com.nicepeople.balancer.configurator.domain.service;

import java.util.List;
import java.util.Optional;

import com.nicepeople.balancer.configurator.domain.model.Account;
import com.nicepeople.balancer.configurator.domain.model.Device;

public interface IAccountService {

	public Account createAccount(Account account);

	public Account getAccount(String code);

	public List<Account> getAllAccounts();

	public Account updateAccount(Account account);

	public void deleteAccount(String code);

	public Optional<Device> findAccountDevice(String accountCode, String targetDevice, String pluginVersion);
}
