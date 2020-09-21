package com.nicepeople.balancer.configurator.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nicepeople.balancer.configurator.domain.exception.AlreadyExistException;
import com.nicepeople.balancer.configurator.domain.exception.NotFoundException;
import com.nicepeople.balancer.configurator.domain.model.Account;
import com.nicepeople.balancer.configurator.domain.model.Device;
import com.nicepeople.balancer.configurator.domain.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {

	private final IAccountRepository accountRepository;

	@Autowired
	public AccountService(final IAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	@Transactional
	public Account createAccount(final Account account) {
		account.validateAccount();
		if (this.accountRepository.get(account.getCode()) != null) {
			throw new AlreadyExistException("Duplicated account code");
		}
		return this.accountRepository.save(account);
	}

	@Override
	public Account getAccount(final String code) {
		return this.accountRepository.get(code);
	}

	@Override
	public List<Account> getAllAccounts() {
		return this.accountRepository.getAll();
	}

	@Override
	@Transactional
	public Account updateAccount(final Account account) {
		account.validateAccount();
		if (this.accountRepository.get(account.getCode()) == null) {
			throw new NotFoundException("Account not exist");
		}
		return this.accountRepository.save(account);
	}

	@Override
	@Transactional
	public void deleteAccount(final String code) {
		this.accountRepository.delete(code);
	}

	@Override
	@Cacheable("accountDevices")
	public Optional<Device> findAccountDevice(final String accountCode, final String targetDevice,
			final String pluginVersion) {

		final Account account = this.accountRepository.get(accountCode);

		if (account == null) {
			return Optional.empty();
		}

		return account.getDevices().stream()
				.filter(d -> d.getDevice().equals(targetDevice) && d.getPluginVersion().equals(pluginVersion))
				.findAny();
	}
}
