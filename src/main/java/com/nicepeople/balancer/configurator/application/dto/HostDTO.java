package com.nicepeople.balancer.configurator.application.dto;

import javax.validation.constraints.NotBlank;

public class HostDTO {

	@NotBlank
	public String endpoint;
	@NotBlank
	public String trafficPercent;

}
