package com.nicepeople.balancer.configurator.domain.model;

import java.io.Serializable;

import com.google.common.base.Strings;
import com.nicepeople.balancer.configurator.domain.exception.InvalidValueException;

public class Host implements Serializable {

	private static final long serialVersionUID = 6472108567655721634L;

	private String endpoint;
	private int trafficPercent;

	public Host(final String endpoint, final int trafficPercent) {
		this.endpoint = endpoint;
		this.setTrafficPercent(trafficPercent);
	}

	public String getEndpoint() {
		return this.endpoint;
	}

	public int getTrafficPercent() {
		return this.trafficPercent;
	}

	public void setTrafficPercent(final int trafficPercent) {
		if (trafficPercent < 0 || trafficPercent > 100) {
			throw new InvalidValueException("Traffic percent must be beetween 0 and 100");
		}

		this.trafficPercent = trafficPercent;
	}

	public void validateHost() {
		if (Strings.isNullOrEmpty(this.endpoint)) {
			throw new InvalidValueException("Endpoint cant be empty");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.endpoint == null) ? 0 : this.endpoint.hashCode());
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
		final Host other = (Host) obj;
		if (this.endpoint == null) {
			if (other.endpoint != null)
				return false;
		} else if (!this.endpoint.equals(other.endpoint))
			return false;
		return true;
	}

	/*** >>> ***/
	// TODO Crear excepciones especificas cara cada tipo de error

	// TODO Codigo para eliminar (solo para generar DB con data inicial)
	@SuppressWarnings("unused")
	private Host() {
	}
	/*** <<< ***/
}
