package com.learning.stall.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class StallKafkaConsumer {

    private static Logger logger = LoggerFactory.getLogger(StallKafkaConsumer.class);

    @KafkaListener(topics="stall-app3", groupId = "notificationNewStall", concurrency = "2")
    public void processMessage(String message){
        System.out.println("Inside process message of Kafka consumer class " + message);
        logger.info("Inside process message of Kafka consumer class using logger {}", message );
    }
}
