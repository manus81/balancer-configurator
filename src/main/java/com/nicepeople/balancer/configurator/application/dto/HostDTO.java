package com.nicepeople.balancer.configurator.application.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class HostDTO implements Serializable {

	private static final long serialVersionUID = -947210856765572189L;

	@NotBlank
	public String endpoint;
	@NotBlank
	public int traffic_percent;

}
