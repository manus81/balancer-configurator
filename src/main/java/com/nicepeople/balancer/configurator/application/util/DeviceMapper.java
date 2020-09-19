package com.nicepeople.balancer.configurator.application.util;

import java.util.Set;
import java.util.stream.Collectors;

import com.nicepeople.balancer.configurator.application.dto.DeviceDTO;
import com.nicepeople.balancer.configurator.application.exception.DeviceMapperException;
import com.nicepeople.balancer.configurator.domain.model.Device;
import com.nicepeople.balancer.configurator.domain.model.Host;

public final class DeviceMapper {

	// TODO usar alguna lib mapper

	private DeviceMapper() {
		// no instanciable (all compatible)
	}

	public static Device toDevice(final DeviceDTO dto) {
		try {
			final Set<Host> hosts = dto.hosts.stream().map(HostMapper::toHost).collect(Collectors.toSet());
			final double pingTimeOrDefault = dto.pingTime != null ? Double.valueOf(dto.pingTime) : 5D;
			return new Device(dto.device, dto.pluginVersion, pingTimeOrDefault,
					hosts);
		} catch (final Exception e) {
			throw new DeviceMapperException(e.getMessage());
		}
	}
}
