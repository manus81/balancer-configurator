package com.nicepeople.balancer.configurator.application.util;

import java.util.Set;
import java.util.stream.Collectors;

import com.nicepeople.balancer.configurator.application.dto.NewAccountDTO;
import com.nicepeople.balancer.configurator.application.exception.AccountMapperException;
import com.nicepeople.balancer.configurator.domain.model.Account;
import com.nicepeople.balancer.configurator.domain.model.Device;

public final class AccountMapper {

	public static Account toAccount(final NewAccountDTO dto) {
		try {
			final Set<Device> devices = dto.targetDevices.stream().map(DeviceMapper::toDevice)
					.collect(Collectors.toSet());
			return new Account(dto.accountCode, devices);
		} catch (final Exception e) {
			throw new AccountMapperException(e.getMessage());
		}
	}
}
