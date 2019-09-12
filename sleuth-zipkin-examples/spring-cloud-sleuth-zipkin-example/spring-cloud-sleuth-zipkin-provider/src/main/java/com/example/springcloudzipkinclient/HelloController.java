package com.example.springcloudzipkinclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String callHome(){

        LOG.info("Starting service2...");

        return "Hello World";
    }


}
