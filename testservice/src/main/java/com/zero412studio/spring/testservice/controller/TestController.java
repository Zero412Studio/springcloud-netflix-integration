package com.zero412studio.spring.testservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zero412studio.spring.testservice.client.helloservice.HelloServiceIntegration;

/**
 * TestController
 */
@RestController
public class TestController {
    private Integer counter = 0;

    @RequestMapping(method = RequestMethod.GET, value = "/", produces = {MediaType.TEXT_HTML_VALUE})
    public String getBaseUrl() throws Exception {
        return "home page hit " + counter++;
    }

    @Autowired
    HelloServiceIntegration helloServiceIntegration;

    @RequestMapping(method = RequestMethod.GET, value = "/hello", produces = {MediaType.TEXT_HTML_VALUE})
    public String getHelloResponse() throws Exception {
        return helloServiceIntegration.getTestResponse();
    }
}
