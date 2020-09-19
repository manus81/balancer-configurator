package com.nicepeople.balancer.configurator.domain.model;

public class Host {

	private String endpoint;
	private Double trafficPercent;

	public Host(String endpoint, Double trafficPercent) {
		this.endpoint = endpoint;
		this.setTrafficPercent(trafficPercent);
	}

	public String getEndpoint() {
		return endpoint;
	}
	
	public Double getTrafficPercent() {
		return trafficPercent;
	}

	public void setTrafficPercent(Double trafficPercent) {
		// TODO validar que trafficPercent este entre 0 y 1
		this.trafficPercent = trafficPercent;
	}
}
