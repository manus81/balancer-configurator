package com.nicepeople.balancer.configurator.application.controller.exception;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class HttpErrorResponse implements Serializable {

	private static final long serialVersionUID = -5930663359565585933L;

	private Integer status;
	private String error;
	private String message;

	public HttpErrorResponse(final Integer status, final String error, final String message) {
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public HttpErrorResponse() {
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(final Integer status) {
		this.status = status;
	}

	public String getError() {
		return this.error;
	}

	public void setError(final String error) {
		this.error = error;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
