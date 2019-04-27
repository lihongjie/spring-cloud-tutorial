package com.github.lihongjie.consumer;


import com.github.lihongjie.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ReplyingKafkaConsumer {

    @KafkaListener(topics = "${kafka.topic.request-topic}")
    @SendTo
    public User listen(User user) {

        Integer age = 10 + user.getAge();
        User u = new User();
        u.setAge(age);
        u.setId("111");
        u.setName("hello");

        return u;
    }
}
