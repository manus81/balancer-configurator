package com.nicepeople.balancer.configurator.application.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nicepeople.balancer.configurator.application.dto.AccountDataDTO;
import com.nicepeople.balancer.configurator.application.service.IAccountDataService;

@RestController
@RequestMapping(value = "/")
public class AccountDataController {

	private final IAccountDataService accountDataService;

	@Autowired
	public AccountDataController(final IAccountDataService accountDataService) {
		this.accountDataService = accountDataService;
	}

	@GetMapping(value = "/getData", produces = MediaType.APPLICATION_XML_VALUE)
	public AccountDataDTO getAccountXmlData(@RequestParam final String accountCode,
			@RequestParam final String targetDevice, @RequestParam final String pluginVersion) {

		return this.getAccountData(accountCode, targetDevice, pluginVersion);
	}

	// Restful json version
	@GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountDataDTO getAccountData(@RequestParam("account_code") final String accountCode,
			@RequestParam("target_device") final String targetDevice,
			@RequestParam("plugin_version") final String pluginVersion) {

		final Optional<AccountDataDTO> accountData = this.accountDataService.getAccountData(accountCode, targetDevice,
				pluginVersion);

		accountData.ifPresent(data -> {
			accountData.get().setViewCode(UUID.randomUUID().toString());
		});

		return accountData.orElse(null);
	}
}
