package com.nicepeople.balancer.configurator.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicepeople.balancer.configurator.application.dto.DeviceDTO;
import com.nicepeople.balancer.configurator.application.dto.HostDTO;
import com.nicepeople.balancer.configurator.application.dto.NewAccountDTO;
import com.nicepeople.balancer.configurator.application.exception.AccountNotFoundException;
import com.nicepeople.balancer.configurator.application.util.AccountMapper;
import com.nicepeople.balancer.configurator.application.util.DeviceMapper;
import com.nicepeople.balancer.configurator.application.util.HostMapper;
import com.nicepeople.balancer.configurator.domain.model.Account;
import com.nicepeople.balancer.configurator.domain.service.IAccountService;

@Service
public class AccountCrudService implements IAccountCrudService {

	private final IAccountService accountService;

	@Autowired
	public AccountCrudService(final IAccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public void createAccount(final NewAccountDTO accountDTO) {
		final Account account = AccountMapper.toAccount(accountDTO);
		this.accountService.createAccount(account);
	}

	@Override
	public Account getAccount(final String accountCode) {
		return this.accountService.getAccount(accountCode);
	}

	@Override
	public List<Account> getAllAccounts() {
		return this.accountService.getAllAccounts();
	}

	@Override
	public void deleteAccount(final String accountCode) {
		this.accountService.deleteAccount(accountCode);
	}

	@Override
	public void addTargetDevice(final String accountCode, final DeviceDTO targetDeviceDTO) {
		final Account account = this.accountService.getAccount(accountCode);

		if (account == null) {
			throw new AccountNotFoundException(accountCode);
		}

		account.addDevice(DeviceMapper.toDevice(targetDeviceDTO));
		this.accountService.updateAccount(account);
	}

	@Override
	public void addHostToDevice(final String accountCode, final String device, final HostDTO hostDTO) {
		final Account account = this.accountService.getAccount(accountCode);

		if (account == null) {
			throw new AccountNotFoundException(accountCode);
		}

		account.addHostToDevice(device, HostMapper.toHost(hostDTO));
		this.accountService.updateAccount(account);
	}
}
