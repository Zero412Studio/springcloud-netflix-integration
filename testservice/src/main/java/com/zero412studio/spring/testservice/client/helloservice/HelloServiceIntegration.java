package com.zero412studio.spring.testservice.client.helloservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * HelloServiceIntegration
 */
@Component
public class HelloServiceIntegration {
	@Autowired
	HelloServiceClient helloServiceClient;

	@HystrixCommand(fallbackMethod = "defaultHello")
	public String getTestResponse() throws Exception {
		return helloServiceClient.getTestResponse();
	}

	public String defaultHello() {
		return "cannot access hello service";
	}

}
