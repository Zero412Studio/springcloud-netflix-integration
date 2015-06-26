package com.zero412studio.spring.testservice.client.helloservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * HelloServiceClient
 */
@FeignClient("https://helloservice")
public interface HelloServiceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/test")
	String getTestResponse();
}
