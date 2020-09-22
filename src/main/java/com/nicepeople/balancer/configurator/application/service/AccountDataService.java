package com.nicepeople.balancer.configurator.application.service;

import java.util.Optional;
import java.util.UUID;

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
	public AccountDataDTO getAccountData(final String accountCode, final String targetDevice,
			final String pluginVersion) {

		final Optional<Device> device = this.accountService.findAccountDevice(accountCode, targetDevice, pluginVersion);

		return device.map(d -> {
			final AccountDataDTO data = new AccountDataDTO(device.get().balance().getEndpoint(),
					device.get().getPingTime());

			// unique view code
			data.setViewCode(UUID.randomUUID().toString());

			return data;
		}).orElse(null);
	}
}
