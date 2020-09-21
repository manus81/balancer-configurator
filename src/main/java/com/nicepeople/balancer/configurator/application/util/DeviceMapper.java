package com.nicepeople.balancer.configurator.application.util;

import java.util.Set;
import java.util.stream.Collectors;

import com.nicepeople.balancer.configurator.application.dto.DeviceDTO;
import com.nicepeople.balancer.configurator.application.exception.DeviceMapperException;
import com.nicepeople.balancer.configurator.domain.model.Device;
import com.nicepeople.balancer.configurator.domain.model.Host;

public final class DeviceMapper {

	public static Device toDevice(final DeviceDTO dto) {
		try {
			final Set<Host> hosts = dto.hosts.stream().map(HostMapper::toHost).collect(Collectors.toSet());
			final int pingTimeOrDefault = dto.ping_time != null ? Integer.valueOf(dto.ping_time) : 5;
			return new Device(dto.device, dto.plugin_version, pingTimeOrDefault, hosts);
		} catch (final Exception e) {
			throw new DeviceMapperException(e.getMessage());
		}
	}
}
