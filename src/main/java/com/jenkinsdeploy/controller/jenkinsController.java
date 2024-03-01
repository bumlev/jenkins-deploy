package com.jenkinsdeploy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class jenkinsController {

    @GetMapping("/")
    public String testJenkins() {

        String message;
        message = "Hello";
        return message;
    }
}
