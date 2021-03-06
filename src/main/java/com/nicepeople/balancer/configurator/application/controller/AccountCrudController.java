package com.nicepeople.balancer.configurator.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nicepeople.balancer.configurator.application.dto.DeviceDTO;
import com.nicepeople.balancer.configurator.application.dto.NewAccountDTO;
import com.nicepeople.balancer.configurator.application.service.IAccountCrudService;
import com.nicepeople.balancer.configurator.domain.model.Account;

@RestController
@RequestMapping(value = "/accounts")
public class AccountCrudController {

	private final IAccountCrudService accountCrudService;

	@Autowired
	public AccountCrudController(final IAccountCrudService accountCrudService) {
		this.accountCrudService = accountCrudService;
	}

	@GetMapping(value = "/{account_code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Account getAccount(@PathVariable("account_code") final String accountCode) {
		return this.accountCrudService.getAccount(accountCode);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> getAllAccounts() {
		return this.accountCrudService.getAllAccounts();
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveAccount(@RequestBody @Valid final NewAccountDTO newAccountDTO) {
		this.accountCrudService.createAccount(newAccountDTO);
	}

	@PutMapping(value = "/{account_code}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void addTargetDeviceToAccount(@PathVariable("account_code") final String accountCode,
			@RequestBody @Valid final DeviceDTO newDeviceDTO) {
		this.accountCrudService.addTargetDevice(accountCode, newDeviceDTO);
	}

	@DeleteMapping(value = "/{account_code}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteAccount(@PathVariable("account_code") final String accountCode) {
		this.accountCrudService.deleteAccount(accountCode);
	}
}
