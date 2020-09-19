package com.nicepeople.balancer.configurator.application.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class DeviceDTO {

	@NotBlank
	public String device;
	@NotBlank
	public String pluginVersion;
	public String pingTime;
	@NotEmpty
	public List<HostDTO> hosts;

}
