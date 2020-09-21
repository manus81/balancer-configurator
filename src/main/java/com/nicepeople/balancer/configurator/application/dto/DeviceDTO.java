package com.nicepeople.balancer.configurator.application.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class DeviceDTO implements Serializable {

	private static final long serialVersionUID = 8772108567655721854L;

	@NotBlank
	public String device;
	@NotBlank
	public String plugin_version;
	public Integer ping_time;
	@NotEmpty
	public List<HostDTO> hosts;

}
