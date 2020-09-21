package com.nicepeople.balancer.configurator.application.service;

import java.util.List;

import com.nicepeople.balancer.configurator.application.dto.HostDTO;
import com.nicepeople.balancer.configurator.application.dto.NewAccountDTO;
import com.nicepeople.balancer.configurator.application.dto.DeviceDTO;
import com.nicepeople.balancer.configurator.domain.model.Account;

public interface IAccountCrudService {

	public void createAccount(final NewAccountDTO accountDTO);

	public Account getAccount(String accountCode);

	public List<Account> getAllAccounts();

	public void deleteAccount(String accountCode);

	void addTargetDevice(String accountCode, DeviceDTO targetDeviceDTO);

	void addHostToDevice(String accountCode, String device, HostDTO hostDTO);

}
