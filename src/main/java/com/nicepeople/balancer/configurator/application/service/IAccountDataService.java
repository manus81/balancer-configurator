package com.nicepeople.balancer.configurator.application.service;

import com.nicepeople.balancer.configurator.application.dto.AccountDataDTO;

public interface IAccountDataService {

	public AccountDataDTO getAccountData(String accountCode, String targetDevice, String pluginVersion);

}
