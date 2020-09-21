package com.nicepeople.balancer.configurator.application.dto;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "q")
public class AccountDataDTO implements Serializable {

	private static final long serialVersionUID = -6172108567655721897L;

	@JacksonXmlProperty(localName = "h")
	private final String host;
	@JacksonXmlProperty(localName = "pt")
	private final int ping;
	@JacksonXmlProperty(localName = "c")
	private String viewCode;

	public AccountDataDTO(final String host, final int ping) {
		this.host = host;
		this.ping = ping;
	}

	public String getHost() {
		return this.host;
	}

	public int getPing() {
		return this.ping;
	}

	public String getViewCode() {
		return this.viewCode;
	}

	public void setViewCode(final String viewCode) {
		this.viewCode = viewCode;
	}
}
