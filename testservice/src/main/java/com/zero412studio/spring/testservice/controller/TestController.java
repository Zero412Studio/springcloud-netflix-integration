package com.zero412studio.spring.testservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
