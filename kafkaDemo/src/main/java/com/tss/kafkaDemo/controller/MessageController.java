package com.tss.kafkaDemo.controller;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private Producer producerService;

    public MessageController(Producer producerService) {
        this.producerService = producerService;
    }

    public ResponseEntity<String> sendMessage(String message)
    {
        producerService.sendMessage
    }
}
