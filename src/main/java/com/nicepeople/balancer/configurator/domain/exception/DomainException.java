package com.nicepeople.balancer.configurator.domain.exception;

public abstract class DomainException extends RuntimeException {

	private static final long serialVersionUID = -5625546453193795408L;

	public DomainException(final String message) {
		super(message);
	}
}
