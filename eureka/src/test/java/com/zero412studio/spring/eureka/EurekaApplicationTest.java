package com.zero412studio.spring.eureka;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * EurekaApplicationTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EurekaApplication.class)
@WebAppConfiguration
@Profile("test")
public class EurekaApplicationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * Sets up the controller to be tested with a mock service.
     */
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * teardown resources
     */
    @After
    public void tearDown() {
        System.out.println("teardown tests");
    }

    @Test
    public void catalogLoads() throws Exception {
        final MvcResult mvcResult = mockMvc.perform(get("/")).andExpect(status().isOk()).andReturn();
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void adminLoads() throws Exception {
        final MvcResult mvcResult = mockMvc.perform(get("/env")).andExpect(status().isOk()).andReturn();
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }
}
