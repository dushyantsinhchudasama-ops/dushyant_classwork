package com.tss.__jpa.controller;

import com.tss.__jpa.services.Notification;
import com.tss.__jpa.services.NotificationProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class NotificationController {

    //the following is used when we want to spesicy types

//    private final Notification notification;
//
//    @PostMapping("/notify")
//    @Qualifier("email")
//    public void sendNotification(@RequestParam String message, @RequestParam String receiver)
//    {
//        notification.sendNotification(message, receiver);
//    }


    //following is for dynamic dependency injection

    private final NotificationProcessor processor;
    private final Notification notification;

    @PostMapping("/notify")
    public void sendNotification(@RequestParam(required = false) String type, @RequestParam String message, @RequestParam String receiver)
    {
        if(type == null)
            notification.sendNotification(message, receiver);
        else
            processor.send(type, message, receiver);
    }
}
