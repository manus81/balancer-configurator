package com.nicepeople.balancer.configurator.domain.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.util.CollectionUtils;

import com.google.common.base.Strings;
import com.nicepeople.balancer.configurator.domain.exception.EmptyException;
import com.nicepeople.balancer.configurator.domain.exception.InvalidValueException;
import com.nicepeople.balancer.configurator.domain.exception.NotFoundException;
import com.nicepeople.balancer.configurator.domain.exception.NullException;

public class Account {

	// TODO mejorar nombres (targetDevices?)
	// TODO crear excepciones especificas

	@Id
	private final String code;
	private final Set<Device> targetDevices = new HashSet<>();

	public Account(final String code, final Set<Device> targetDevices) {
		if (Strings.isNullOrEmpty(code)) {
			throw new InvalidValueException("Endpoint cant be empty");
		}

		this.code = code;
		this.addTargetDevices(targetDevices);
	}

	public String getCode() {
		return this.code;
	}

	public Set<Device> getTargetDevices() {
		return Collections.unmodifiableSet(this.targetDevices);
	}

	public void addTargetDevices(final Set<Device> targetDevices) {
		if (CollectionUtils.isEmpty(targetDevices)) {
			throw new EmptyException("Target devices cant be empty");
		}

		this.targetDevices.addAll(targetDevices);
	}

	public void addTargetDevice(final Device targetDevice) {
		if (targetDevice == null) {
			throw new NullException("Target device cant be null");
		}

		this.targetDevices.add(targetDevice);
	}

	public void addHostToDevice(final String targetDevice, final Host host) {
		final Optional<Device> device = this.targetDevices.stream().filter(d -> d.getDevice().equals(targetDevice))
				.findAny();

		if (device.isEmpty()) {
			throw new NotFoundException("Target device not exist in this account");
		}

		device.get().addHost(host);
	}

	public void removeTargetDevice(final Device targetDevice) {
		if (targetDevice == null) {
			throw new NullException("Target device cant be null");
		}

		this.targetDevices.remove(targetDevice);
	}

	public void validateAccount() {
		if (CollectionUtils.isEmpty(this.targetDevices)) {
			throw new NullException("Target devices cant be empty");
		}

		this.targetDevices.forEach(Device::validateDevice);
		// TODO extra validations
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final Account other = (Account) obj;
		if (this.code == null) {
			if (other.code != null)
				return false;
		} else if (!this.code.equals(other.code))
			return false;
		return true;
	}
}
