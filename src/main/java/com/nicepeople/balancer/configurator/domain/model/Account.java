package com.nicepeople.balancer.configurator.domain.model;

import java.io.Serializable;
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

public class Account implements Serializable {

	private static final long serialVersionUID = 2347210856765572189L;

	@Id
	private String code;
	private Set<Device> devices = new HashSet<>();

	public Account(final String code, final Set<Device> devices) {
		if (Strings.isNullOrEmpty(code)) {
			throw new InvalidValueException("Endpoint cant be empty");
		}

		this.code = code;
		this.addDevices(devices);
	}

	public String getCode() {
		return this.code;
	}

	public Set<Device> getDevices() {
		return Collections.unmodifiableSet(this.devices);
	}

	public void addDevices(final Set<Device> devices) {
		if (CollectionUtils.isEmpty(devices)) {
			throw new EmptyException("Target devices cant be empty");
		}

		this.devices.addAll(devices);
	}

	public void addDevice(final Device device) {
		if (device == null) {
			throw new NullException("Target device cant be null");
		}

		this.devices.add(device);
	}

	public void addHostToDevice(final String device, final Host host) {
		final Optional<Device> oDevice = this.devices.stream().filter(d -> d.getDevice().equals(device)).findAny();

		if (oDevice.isEmpty()) {
			throw new NotFoundException("Target device not exist in this account");
		}

		oDevice.get().addHost(host);
	}

	public void removeDevice(final Device device) {
		if (device == null) {
			throw new NullException("Target device cant be null");
		}

		this.devices.remove(device);
	}

	public void validateAccount() {
		if (CollectionUtils.isEmpty(this.devices)) {
			throw new NullException("Target devices cant be empty");
		}

		this.devices.forEach(Device::validateDevice);
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

	/*** >>> ***/
	// TODO Crear excepciones especificas cara cada tipo de error

	// TODO Codigo para eliminar (solo para generar DB con data inicial)
	@SuppressWarnings("unused")
	private Account() {
	}

	@SuppressWarnings("unused")
	private void setDevices(final Set<Device> devices) {
		this.devices = devices;
	}
	/*** <<< ***/
}
