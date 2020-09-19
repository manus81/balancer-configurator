package com.nicepeople.balancer.configurator.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nicepeople.balancer.configurator.application.dto.AccountDTO;
import com.nicepeople.balancer.configurator.application.dto.DeviceDTO;
import com.nicepeople.balancer.configurator.application.service.IAccountApplicationService;
import com.nicepeople.balancer.configurator.domain.model.Account;

@RestController
//@RequestMapping(value = "/accounts")
@RequestMapping(value = "/")
public class AccountController {

	private final IAccountApplicationService accountApplicationService;

	@Autowired
	public AccountController(final IAccountApplicationService accountApplicationService) {
		this.accountApplicationService = accountApplicationService;
	}

	@GetMapping(value = "/{account_code}")
	public Account getAccount(@PathVariable("account_code") final String accountCode) {
		return this.accountApplicationService.getAccount(accountCode);
	}

	@GetMapping()
	public List<Account> getAllAccounts() {
		return this.accountApplicationService.getAllAccounts();
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void saveAccount(@RequestBody @Valid final AccountDTO accountDTO) {
		this.accountApplicationService.createAccount(accountDTO);
	}

	@PutMapping()
	@ResponseStatus(HttpStatus.OK)
	public void updateAccount(@RequestBody @Valid final AccountDTO accountDTO) {
		this.accountApplicationService.createAccount(accountDTO);
	}

	@PutMapping(value = "/{account_code}")
	@ResponseStatus(HttpStatus.OK)
	public void addTargetDeviceToAccount(@PathVariable("account_code") final String accountCode,
			@RequestBody @Valid final DeviceDTO targetDeviceDTO) {
		this.accountApplicationService.addTargetDevice(accountCode, targetDeviceDTO);
	}

	@DeleteMapping(value = "/{account_code}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAccount(@PathVariable("account_code") final String accountCode) {
		this.accountApplicationService.deleteAccount(accountCode);
	}
}
