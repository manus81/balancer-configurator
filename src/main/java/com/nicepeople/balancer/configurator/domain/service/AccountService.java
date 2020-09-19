package com.nicepeople.balancer.configurator.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicepeople.balancer.configurator.domain.exception.AlreadyExistException;
import com.nicepeople.balancer.configurator.domain.exception.NotFoundException;
import com.nicepeople.balancer.configurator.domain.model.Account;
import com.nicepeople.balancer.configurator.domain.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {

	private final IAccountRepository accountRepository;

	@Autowired
	public AccountService(final IAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
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
	public Account updateAccount(final Account account) {
		account.validateAccount();
		if (this.accountRepository.get(account.getCode()) == null) {
			throw new NotFoundException("Account not exist");
		}
		return this.accountRepository.save(account);
	}

	@Override
	public void deleteAccount(final String code) {
		this.accountRepository.delete(code);
	}
}
