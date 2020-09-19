package com.nicepeople.balancer.configurator.domain.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import com.nicepeople.balancer.configurator.domain.exception.EmptyException;
import com.nicepeople.balancer.configurator.domain.exception.InvalidValueException;
import com.nicepeople.balancer.configurator.domain.exception.NullException;

public class Device {

	// TODO crear excepciones especificas

	private final String device;
	private String pluginVersion;
	private Double pingTime;
	private final Set<Host> hosts = new HashSet<>();

	public Device(final String device, final String pluginVersion, final Double pingTime, final Set<Host> hosts) {
		this.device = device;
		this.pluginVersion = pluginVersion;
		this.pingTime = pingTime;
		this.addHosts(hosts);
	}

	public String getDevice() {
		return this.device;
	}

	public String getPluginVersion() {
		return this.pluginVersion;
	}

	public void setPluginVersion(final String pluginVersion) {
		this.pluginVersion = pluginVersion;
	}

	public Double getPingTime() {
		return this.pingTime;
	}

	public void setPingTime(final Double pingTime) {
		if (pingTime == null || !(pingTime > 0)) {
			throw new InvalidValueException("Invalid pingTime");
		}

		this.pingTime = pingTime;
	}

	public Set<Host> getHosts() {
		return Collections.unmodifiableSet(this.hosts);
	}

	public void addHosts(final Set<Host> hosts) {
		if (CollectionUtils.isEmpty(hosts)) {
			throw new EmptyException("Hosts cant be empty");
		}

		this.hosts.addAll(hosts);
	}

	public void addHost(final Host host) {
		if (host == null) {
			throw new NullException("Host cant be null");
		}

		this.hosts.add(host);
	}

	public void removeHost(final Host host) {
		if (host == null) {
			throw new NullException("Host cant be null");
		}

		this.hosts.remove(host);
	}

	public void validateDevice() {
		this.validateHosts();
		// TODO extra validations
	}

	private void validateHosts() {
		if (CollectionUtils.isEmpty(this.hosts)) {
			throw new EmptyException("Hosts cant be empty");
		}

		final Double hostPercentages = this.hosts.stream().peek(Host::validateHost).map(Host::getTrafficPercent)
				.reduce((a, b) -> a + b).get();
		if (Double.compare(1D, hostPercentages) != 0) {
			throw new InvalidValueException("Hosts percentages from device must totalize 1 (100%)");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.device == null) ? 0 : this.device.hashCode());
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
		final Device other = (Device) obj;
		if (this.device == null) {
			if (other.device != null)
				return false;
		} else if (!this.device.equals(other.device))
			return false;
		return true;
	}
}
