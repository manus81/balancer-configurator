package com.nicepeople.balancer.configurator.application.service;

import java.util.Optional;

import com.nicepeople.balancer.configurator.application.dto.AccountDataDTO;

public interface IAccountDataService {

	public Optional<AccountDataDTO> getAccountData(String accountCode, String targetDevice, String pluginVersion);

}
