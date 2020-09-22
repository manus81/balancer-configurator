package com.nicepeople.balancer.configurator.domain.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.nicepeople.balancer.configurator.domain.exception.EmptyException;
import com.nicepeople.balancer.configurator.domain.exception.InvalidValueException;
import com.nicepeople.balancer.configurator.domain.exception.NullException;

public class Device implements Serializable {

	private static final long serialVersionUID = 4672108567655721863L;

	// TODO cambiar device por name
	private String device;
	private String pluginVersion;
	private int pingTime;
	private Set<Host> hosts = new HashSet<>();
	private List<Host> balancedHosts = Lists.newArrayListWithCapacity(100);

	public Device(final String device, final String pluginVersion, final int pingTime, final Set<Host> hosts) {
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

	public int getPingTime() {
		return this.pingTime;
	}

	public void setPingTime(final int pingTime) {
		if (pingTime < 1) {
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
		this.fillBalancedHosts();
	}

	private void validateHosts() {
		if (CollectionUtils.isEmpty(this.hosts)) {
			throw new EmptyException("Hosts cant be empty");
		}

		final int hostPercentages = this.hosts.stream().peek(Host::validateHost).map(Host::getTrafficPercent)
				.reduce((a, b) -> a + b).get();
		if (hostPercentages != 100) {
			throw new InvalidValueException("Hosts percentages from device must totalize 100");
		}
	}

	private void fillBalancedHosts() {
		this.balancedHosts.clear();
		this.hosts.forEach(h -> {
			for (int i = 0; i < h.getTrafficPercent(); i++) {
				this.balancedHosts.add(h);
			}
		});
	}

	/**
	 * @return a host according to their percentages
	 */
	public Host balance() {
		// this.validateHosts();
		if (this.balancedHosts.isEmpty()) {
			this.fillBalancedHosts();
		}

		final int randomIndex = RandomUtils.nextInt(0, 99);
		return this.balancedHosts.get(randomIndex);
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

	/*** >>> ***/
	// TODO Crear excepciones especificas cara cada tipo de error

	// TODO Codigo para eliminar (solo para generar DB con data inicial)
	@SuppressWarnings("unused")
	private Device() {
	}

	@SuppressWarnings("unused")
	private void setHosts(final Set<Host> hosts) {
		this.hosts = hosts;
	}

	@SuppressWarnings("unused")
	private void setBalancedHosts(final List<Host> balancedHosts) {
		this.balancedHosts = balancedHosts;
	}
	/*** <<< ***/
}
