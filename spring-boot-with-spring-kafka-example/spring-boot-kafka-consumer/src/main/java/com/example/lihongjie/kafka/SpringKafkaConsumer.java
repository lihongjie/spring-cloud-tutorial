package com.example.lihongjie.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SpringKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(SpringKafkaConsumer.class);

    @KafkaListener(topics = {"app_log"})
    public void receive(ConsumerRecord<?, ?> record) {

        log.info("kafka的key: " + record.key());
        log.info("kafka的value: " + record.value().toString());

    }

//    @KafkaListener(topics = {"app_log"})
//    public void receive(String message) {
//
//        System.out.println("消费消息 : " + message);
//    }

}
