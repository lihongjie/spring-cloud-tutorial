package com.github.lihongjie.controller;

import com.github.lihongjie.model.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class ProducerController {

    @Autowired
    private ReplyingKafkaTemplate<String, User, User> kafkaTemplate;

    @Value("${kafka.topic.request-topic}")
    private String requestTopic;

    @Value("${kafka.topic.request-reply-topic}")
    private String requestReplyTopic;

    @PostMapping(value = "/users")
    public User sum(@RequestBody User user) throws ExecutionException, InterruptedException {

        // create producer record
        ProducerRecord<String, User> record = new ProducerRecord<>(requestTopic, user);
        // set reply topic in header
        record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, requestReplyTopic.getBytes()));
        // post in kafka topic
        RequestReplyFuture<String, User, User> sendAndReceive = kafkaTemplate.sendAndReceive(record);
        // confirm if producer produced successfully
        SendResult<String, User> sendResult = sendAndReceive.getSendFuture().get();
        //print all headers
        Headers headers = sendResult.getProducerRecord().headers();

        for (Header header : headers) {
            System.out.println(header.key() + ":" + header.value().toString());
        }
        // get consumer record
        ConsumerRecord<String, User> consumerRecord = sendAndReceive.get();
        User response = consumerRecord.value();
        return response;
    }

}











