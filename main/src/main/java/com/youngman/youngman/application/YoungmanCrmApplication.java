package com.youngman.youngman.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication

@ComponentScan(basePackages = {"com.youngman.*"})
public class YoungmanCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoungmanCrmApplication.class, args);
	}

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}

}
