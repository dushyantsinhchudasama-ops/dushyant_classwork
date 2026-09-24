package com.tss.kafkaDemo.service;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ProducerService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ProducerService.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message)
    {
        logger.info("sending message: " + message );
        kafkaTemplate.send("myTopic",message);
    }
}

