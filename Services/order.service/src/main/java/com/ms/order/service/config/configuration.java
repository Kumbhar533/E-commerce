package com.ms.order.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class configuration {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
