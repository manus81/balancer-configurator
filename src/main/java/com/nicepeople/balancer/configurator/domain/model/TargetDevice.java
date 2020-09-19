package com.nicepeople.balancer.configurator.domain.model;

import java.util.HashSet;
import java.util.Set;

public class TargetDevice {

	private String device;
	private String pluginVersion;
	private Double pingTime;
	private Set<Host> hosts = new HashSet<>();
	
	public TargetDevice(String device, String pluginVersion, Double pingTime, Set<Host> hosts) {
		this.device = device;
		this.pluginVersion = pluginVersion;
		this.pingTime = pingTime;
		this.addHosts(hosts);
	}

	public String getDevice() {
		return device;
	}

	public String getPluginVersion() {
		return pluginVersion;
	}

	public void setPluginVersion(String pluginVersion) {
		this.pluginVersion = pluginVersion;
	}

	public Double getPingTime() {
		return pingTime;
	}

	public void setPingTime(Double pingTime) {
		// TODO validar que pingTime sea mayor a 0
		this.pingTime = pingTime;
	}

	public Set<Host> getHosts() {
		// TODO devolver inmutable set
		return hosts;
	}

	public void addHosts(Set<Host> hosts) {
		// TODO Validar que hosts no sea null
		this.hosts.addAll(hosts);
	}
	
	public void addHost(Host host) {
		// TODO Validar que host no sea null
		this.hosts.add(host);
	}
}
