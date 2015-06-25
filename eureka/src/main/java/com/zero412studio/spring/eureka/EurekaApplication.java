package com.zero412studio.spring.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaApplication
 */
@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class EurekaApplication {
	public static void main(final String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
}
