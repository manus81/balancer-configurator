package com.nicepeople.balancer.configurator.domain.model;

public class Host {

	private final String endpoint;
	private Double trafficPercent;

	public Host(final String endpoint, final Double trafficPercent) {
		this.endpoint = endpoint;
		this.setTrafficPercent(trafficPercent);
	}

	public String getEndpoint() {
		return this.endpoint;
	}

	public Double getTrafficPercent() {
		return this.trafficPercent;
	}

	public void setTrafficPercent(final Double trafficPercent) {
		// TODO validar que trafficPercent este entre 0 y 1
		this.trafficPercent = trafficPercent;
	}
}
