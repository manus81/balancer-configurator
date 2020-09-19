package com.nicepeople.balancer.configurator.domain.exception;

public class AlreadyExistException extends DomainException {

	private static final long serialVersionUID = 4726869549507123454L;

	public AlreadyExistException(final String message) {
		super(message);
	}
}
