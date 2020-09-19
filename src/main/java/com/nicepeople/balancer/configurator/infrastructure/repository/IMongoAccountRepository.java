package com.nicepeople.balancer.configurator.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nicepeople.balancer.configurator.domain.model.Account;

public interface IMongoAccountRepository extends MongoRepository<Account, String> {
}
