package com.nicepeople.balancer.configurator.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nicepeople.balancer.configurator.domain.model.Account;
import com.nicepeople.balancer.configurator.domain.repository.IAccountRepository;

@Repository
@Qualifier(value = "accountRepository")
public class MongoAccountRepository implements IAccountRepository {

	private final IMongoAccountRepository iMongoAccountRepository;

	public MongoAccountRepository(final IMongoAccountRepository iMongoAccountRepository) {
		this.iMongoAccountRepository = iMongoAccountRepository;
	}

	@Override
	public Account get(final String code) {
		return this.iMongoAccountRepository.findById(code).orElse(null);
	}

	@Override
	public List<Account> getAll() {
		return this.iMongoAccountRepository.findAll();
	}

	@Override
	public Account save(final Account account) {
		return this.iMongoAccountRepository.save(account);
	}

	@Override
	public void delete(final String code) {
		this.iMongoAccountRepository.deleteById(code);
	}
}
