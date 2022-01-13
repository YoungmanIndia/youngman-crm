package com.youngman.model.business.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.youngman.model.business"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.youngman.model.business.repositories")
@EntityScan(basePackages = "com.youngman.model.model")
@EnableTransactionManagement
@ImportResource("classpath:/spring/youngman-core-context.xml")
public class CoreApplicationConfiguration {
}
