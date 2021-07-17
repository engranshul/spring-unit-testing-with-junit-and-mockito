package com.in28minutes.unittesting.unittesting.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;

@WebMvcTest(HelloWorldController.class)
public class MyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testMyController() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/test")
                .accept(MediaType.APPLICATION_JSON);
        // andExpect can be chained
        MvcResult result = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn();

        // below line not required if we use andExpect..
        Assertions.assertEquals("Hello World",result.getResponse().getContentAsString());
    }
}