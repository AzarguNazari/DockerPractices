package com.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndpoints {

    @GetMapping("/")
    public String getString(){
        return "Hello world";
    }

}
