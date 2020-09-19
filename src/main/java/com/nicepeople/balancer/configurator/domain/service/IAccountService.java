package com.nicepeople.balancer.configurator.domain.service;

import java.util.List;
import java.util.Set;

import com.nicepeople.balancer.configurator.domain.model.Account;
import com.nicepeople.balancer.configurator.domain.model.Host;
import com.nicepeople.balancer.configurator.domain.model.TargetDevice;

public interface IAccountService {

	public Account createAccount(String accountCode, Set<TargetDevice> targetDevices);

	public Account getAccount(String accountCode);

	public List<Account> getAllAccounts();

	public Account updateAccount(Account account);

	void addTargetDevice(String accountCode, TargetDevice targetDevice);

	void addHost(String accountCode, String device, Host host);

}
