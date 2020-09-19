package com.nicepeople.balancer.configurator.domain.exception;

public class EmptyException extends DomainException {

	private static final long serialVersionUID = 4726869549507123454L;

	public EmptyException(final String message) {
		super(message);
	}
}
