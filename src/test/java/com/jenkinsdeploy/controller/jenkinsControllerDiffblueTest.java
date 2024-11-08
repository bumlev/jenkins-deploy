package com.jenkinsdeploy.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {jenkinsController.class})
@ExtendWith(SpringExtension.class)
class jenkinsControllerDiffblueTest {
    @Autowired
    private jenkinsController jenkinsController;

    /**
     * Method under test: {@link jenkinsController#testJenkins()}
     */
    @Test
    void testTestJenkins() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/test/");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(jenkinsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Hello"));
    }

    /**
     * Method under test: {@link jenkinsController#testJenkins()}
     */
    @Test
    void testTestJenkins2() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/test/", "Uri Variables");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(jenkinsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Hello"));
    }
}
