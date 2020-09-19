package com.nicepeople.balancer.configurator.domain.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

public class Account {

	@Id
	private final String accountCode;
	private final Set<TargetDevice> targetDevices = new HashSet<>();

	public Account(final String accountCode, final Set<TargetDevice> targetDevices) {
		this.accountCode = accountCode;
		this.addTargetDevices(targetDevices);
	}

	public String getAccountCode() {
		return this.accountCode;
	}

	public Set<TargetDevice> getTargetDevices() {
		// TODO devolver inmutable set
		return this.targetDevices;
	}

	public void addTargetDevices(final Set<TargetDevice> targetDevices) {
		// TODO Validar que targetDevices no sea null
		this.targetDevices.addAll(targetDevices);
	}

	public void addTargetDevice(final TargetDevice targetDevice) {
		// TODO Validar que targetDevice no sea null
		this.targetDevices.add(targetDevice);
	}
}
