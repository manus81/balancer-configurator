package com.nicepeople.balancer.configurator.application.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class NewAccountDTO implements Serializable {

	private static final long serialVersionUID = 7172108567655721894L;

	@NotBlank
	public String accountCode;
	@NotEmpty
	public List<DeviceDTO> targetDevices;

}
