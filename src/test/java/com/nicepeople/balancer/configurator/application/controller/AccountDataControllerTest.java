package com.nicepeople.balancer.configurator.application.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
class AccountDataControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	@Test
	void emptyResponse() {
		try {
			this.mockMvc.perform(
					get("/getData").param("accountCode", "a").param("pluginVersion", "1").param("targetDevice", "x"))
					.andExpect(status().isOk()).andExpect(content().string(StringUtils.EMPTY));
		} catch (final Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void dataResponse() {
		try {
			this.mockMvc
					.perform(get("/getData").param("accountCode", "clienteA").param("pluginVersion", "3.3.2")
							.param("targetDevice", "Panasonic"))
					.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML))
					.andExpect(content().string(containsString("clusterB")));
		} catch (final Exception e) {
			fail(e.getMessage());
		}
	}
}
