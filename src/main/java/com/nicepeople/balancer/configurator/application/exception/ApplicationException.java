package com.nicepeople.balancer.configurator.application.exception;

public abstract class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 3625546453193795408L;

	public ApplicationException(final String message, final Throwable e) {
		super(message, e);
	}

	public ApplicationException(final String message) {
		super(message);
	}
}
