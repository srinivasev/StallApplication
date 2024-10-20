package com.learning.stall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StallKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Async
    public void sendMessage(String message){
        while(true){
            kafkaTemplate.send("stall-app3", String.valueOf(new Date()));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Inside sendMessage method of Kafka producer class" + Thread.currentThread().getName());
        }
    }
}
