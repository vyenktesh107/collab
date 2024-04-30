package com.cjc.Consumer_InevntoryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerInevntoryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerInevntoryAppApplication.class, args);
	}
	@LoadBalanced
	@Bean
	public RestTemplate rt() {
		RestTemplate rs= new RestTemplate();
		return rs;
	}

}
