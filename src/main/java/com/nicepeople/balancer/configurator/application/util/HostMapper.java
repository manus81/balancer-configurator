package com.nicepeople.balancer.configurator.application.util;

import com.nicepeople.balancer.configurator.application.dto.HostDTO;
import com.nicepeople.balancer.configurator.application.exception.HostMapperException;
import com.nicepeople.balancer.configurator.domain.model.Host;

public final class HostMapper {

	public static Host toHost(final HostDTO dto) {
		try {
			return new Host(dto.endpoint, dto.traffic_percent);
		} catch (final Exception e) {
			throw new HostMapperException(e.getMessage());
		}
	}
}
