package com.nicepeople.balancer.configurator.domain.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

public class Account {

	@Id
	private String accountCode;
	private Set<TargetDevice> targetDevices = new HashSet<>();
	
	public Account(String accountCode, Set<TargetDevice> targetDevices) {
		this.accountCode = accountCode;
		this.addTargetDevices(targetDevices);
	}

	public String getAccountCode() {
		return accountCode;
	}

	public Set<TargetDevice> getTargetDevices() {
		// TODO devolver inmutable set
		return targetDevices;
	}

	public void addTargetDevices(Set<TargetDevice> targetDevices) {
		// TODO Validar que targetDevices no sea null
		this.targetDevices.addAll(targetDevices);
	}
	
	public void addTargetDevice(TargetDevice targetDevice) {
		// TODO Validar que targetDevice no sea null
		this.targetDevices.add(targetDevice);
	}
}
