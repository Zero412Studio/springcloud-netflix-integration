package com.zero412studio.spring.helloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * HelloApplication
 */
@SpringBootApplication
@EnableWebMvc
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class HelloApplication {
	public static void main(final String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
}
