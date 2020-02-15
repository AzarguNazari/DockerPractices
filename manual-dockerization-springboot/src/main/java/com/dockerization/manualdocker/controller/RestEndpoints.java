package com.dockerization.manualdocker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndpoints {

    private final static Logger LOGGER = LoggerFactory.getLogger(RestEndpoints.class);

    @GetMapping("/")
    public String getString(){
        LOGGER.debug("The request is received and here is the debug");
        LOGGER.info("The request is received and here is the info");
        LOGGER.error("The request is received and here is the error");
        return "Hello world";
    }

}
