package org.springcloud.hystrix.example.resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class UsersResource {


    @HystrixCommand(groupKey = "hello", commandKey = "hello", fallbackMethod = "fallBackHello")
    @GetMapping(value = "/hello")
    public String hystrix() {
        if (RandomUtils.nextBoolean()) {
            throw new RuntimeException("Failed");
        }
        return "Hello World";
    }

    public String fallBackHello() {
        return "Fall Back Hello";
    }




























}
