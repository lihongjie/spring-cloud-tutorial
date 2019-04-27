package org.springcloud.hystrix.example.resource;

import org.springcloud.hystrix.example.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class UsersResource {


    @GetMapping(value = "/users")
    public List<User> hystrix() {

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId("001");
        user1.setAge("15");
        user1.setName("foo");
        User user2 = new User();
        user2.setId("002");
        user2.setAge("20");
        user2.setName("bar");
        users.add(user1);
        users.add(user2);

        return users;
    }

}
