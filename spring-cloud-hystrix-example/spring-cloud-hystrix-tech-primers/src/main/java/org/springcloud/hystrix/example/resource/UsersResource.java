package org.springcloud.hystrix.example.resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springcloud.hystrix.example.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:8081/rest/users";

    @HystrixCommand(groupKey = "fallback", commandKey = "fallback", fallbackMethod = "hystrixFallBack")
    @GetMapping(value = "/hystrix")
    public List<User> hystrix() {
        List<User> users = restTemplate.getForObject(url, List.class);
        return users;
    }

    public List<User> hystrixFallBack() {
        return Collections.emptyList();
    }




























}
