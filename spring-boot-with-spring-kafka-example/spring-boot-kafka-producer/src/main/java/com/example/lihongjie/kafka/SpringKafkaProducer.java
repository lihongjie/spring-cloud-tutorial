package com.example.lihongjie.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * 生产者
 * 使用@EnableScheduling注解开启定时任务，每秒发送一次。
 */
@Component
@EnableScheduling
public class SpringKafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Scheduled(cron = "00/1 * * * * ?")
    public void send() {
        String message = UUID.randomUUID().toString();
        ListenableFuture future = kafkaTemplate.send("app_log","test", message);
        future.addCallback(o -> System.out.println("send-消息发送成功: " + message), throwable -> System.out.println("消息发送失败： " + message));
    }


}
