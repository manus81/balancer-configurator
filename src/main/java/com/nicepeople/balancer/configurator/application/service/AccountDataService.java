package com.nicepeople.balancer.configurator.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicepeople.balancer.configurator.application.dto.AccountDataDTO;
import com.nicepeople.balancer.configurator.domain.model.Device;
import com.nicepeople.balancer.configurator.domain.service.IAccountService;

@Service
public class AccountDataService implements IAccountDataService {

	private final IAccountService accountService;

	@Autowired
	public AccountDataService(final IAccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public Optional<AccountDataDTO> getAccountData(final String accountCode, final String targetDevice,
			final String pluginVersion) {

		final Optional<Device> device = this.accountService.findAccountDevice(accountCode, targetDevice, pluginVersion);

		return device.isPresent()
				? Optional.of(new AccountDataDTO(device.get().balance().getEndpoint(), device.get().getPingTime()))
				: Optional.empty();
	}
}
