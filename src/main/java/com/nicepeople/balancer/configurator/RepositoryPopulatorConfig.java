package com.nicepeople.balancer.configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

/**
 * Data inicial para poder probar sin tener que crear a mano
 */
@Configuration
public class RepositoryPopulatorConfig {

	@Bean
	public Jackson2RepositoryPopulatorFactoryBean getRespositoryPopulator() {
		final Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
		factory.setResources(new Resource[] { new ClassPathResource("initial-accounts-data.json") });
		return factory;
	}
}
