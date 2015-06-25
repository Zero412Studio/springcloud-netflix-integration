package com.zero412studio.spring.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * EurekaApplication
 */
@SpringBootApplication
@EnableWebMvc
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableZuulProxy
public class ZuulApplication {
	public static void main(final String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
