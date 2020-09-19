package com.nicepeople.balancer.configurator.domain.exception;

public class NotFoundException extends DomainException {

	private static final long serialVersionUID = 4726869549507123454L;

	public NotFoundException(final String message) {
		super(message);
	}
}
