package com.nicepeople.balancer.configurator.domain.model;

import java.util.HashSet;
import java.util.Set;

public class TargetDevice {

	private final String device;
	private String pluginVersion;
	private Double pingTime;
	private final Set<Host> hosts = new HashSet<>();

	public TargetDevice(final String device, final String pluginVersion, final Double pingTime, final Set<Host> hosts) {
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
		// TODO validar que pingTime sea mayor a 0
		this.pingTime = pingTime;
	}

	public Set<Host> getHosts() {
		// TODO devolver inmutable set
		return this.hosts;
	}

	public void addHosts(final Set<Host> hosts) {
		// TODO Validar que hosts no sea null
		this.hosts.addAll(hosts);
	}

	public void addHost(final Host host) {
		// TODO Validar que host no sea null
		this.hosts.add(host);
	}
}
