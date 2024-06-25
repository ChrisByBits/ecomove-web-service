package com.ecogo.ecomove_web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EcomoveWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomoveWebServiceApplication.class, args);
	}
}
