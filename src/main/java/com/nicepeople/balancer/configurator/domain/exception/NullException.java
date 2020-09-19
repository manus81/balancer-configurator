package com.nicepeople.balancer.configurator.domain.exception;

public class NullException extends DomainException {

	private static final long serialVersionUID = 4726869549507123454L;

	public NullException(final String message) {
		super(message);
	}
}
