package com.nicepeople.balancer.configurator.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.nicepeople.balancer.configurator.application.dto.AccountDataDTO;
import com.nicepeople.balancer.configurator.domain.model.Account;
import com.nicepeople.balancer.configurator.domain.model.Device;
import com.nicepeople.balancer.configurator.domain.model.Host;
import com.nicepeople.balancer.configurator.domain.repository.IAccountRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
class AccountDataServiceTest {

	@Autowired
	IAccountRepository accountRepository;

	@Autowired
	IAccountDataService accountDataService;

	private Account account;
	private Device device;

	@Test
	@BeforeAll
	void accountRepository() {

		final List<Account> allAccounts = this.accountRepository.getAll();
		assertNotNull(allAccounts);
		assertEquals(allAccounts.size(), 2);

		this.account = this.accountRepository.get("clienteA");
		assertNotNull(this.account);
		assertEquals(this.account.getCode(), "clienteA");
		assertNotNull(this.account.getDevices());
		assertEquals(this.account.getDevices().size(), 2);

		this.device = this.account.getDevices().iterator().next();
		assertNotNull(this.device);
	}

	@Test
	void accountDataService() {

		// No retorna info para estos inputs
		final AccountDataDTO data1 = this.accountDataService.getAccountData(this.account.getCode(), "DeviceNonExist",
				this.device.getPluginVersion());
		assertNull(data1);

		// Retorna info para estos inputs
		final AccountDataDTO data2 = this.accountDataService.getAccountData(this.account.getCode(),
				this.device.getDevice(), this.device.getPluginVersion());
		assertNotNull(data2);
		assertEquals(data2.getPing(), this.device.getPingTime());

		// Retorna info para los mismos inputs, pero el codigo debe ser distinto
		final AccountDataDTO data2_clone = this.accountDataService.getAccountData(this.account.getCode(),
				this.device.getDevice(), this.device.getPluginVersion());
		assertNotNull(data2_clone);
		assertEquals(data2_clone.getPing(), this.device.getPingTime());
		assertNotEquals(data2.getViewCode(), data2_clone.getViewCode());
	}

	@Test
	void clusterBalance() {
		final Host balancedHost = this.device.balance();
		assertNotNull(balancedHost);
		assertTrue(balancedHost.getTrafficPercent() >= 0);
		assertTrue(balancedHost.getTrafficPercent() <= 100);
	}
}
