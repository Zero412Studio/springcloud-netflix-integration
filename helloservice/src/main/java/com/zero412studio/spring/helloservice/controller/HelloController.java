package com.zero412studio.spring.helloservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */
@RestController
public class HelloController {
	private Integer counter = 0;

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String getHelloHomePage() {
		return "hello from HelloController";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/test", produces = MediaType.TEXT_HTML_VALUE)
	public String echoForTest() {
		return "echo from HelloController " + counter++;
	}
}
