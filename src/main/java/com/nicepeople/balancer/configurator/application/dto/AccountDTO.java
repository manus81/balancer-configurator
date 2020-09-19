package com.nicepeople.balancer.configurator.application.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class AccountDTO {

	@NotBlank
	public String accountCode;
	@NotEmpty
	public List<DeviceDTO> targetDevices;

}
