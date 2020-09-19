package com.nicepeople.balancer.configurator.application.exception;

public class AccountNotFoundException extends ApplicationException {

	private static final long serialVersionUID = 1585869549507123454L;

	public AccountNotFoundException(final String account) {
		super(account);
	}
}
