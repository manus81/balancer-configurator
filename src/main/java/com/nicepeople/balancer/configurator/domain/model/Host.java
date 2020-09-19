package com.nicepeople.balancer.configurator.domain.model;

import com.google.common.base.Strings;
import com.nicepeople.balancer.configurator.domain.exception.InvalidValueException;

public class Host {

	// TODO crear excepciones especificas

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
		if (trafficPercent == null || trafficPercent < 0 || trafficPercent > 1) {
			throw new InvalidValueException("Traffic percent must be beetween 0 and 1");
		}

		this.trafficPercent = trafficPercent;
	}

	public void validateHost() {
		if (Strings.isNullOrEmpty(this.endpoint)) {
			throw new InvalidValueException("Endpoint cant be empty");
		}

		// TODO extra validations
	}
}
