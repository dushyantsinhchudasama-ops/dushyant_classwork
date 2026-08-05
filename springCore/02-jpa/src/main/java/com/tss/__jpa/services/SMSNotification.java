package com.tss.__jpa.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("sms")
@Primary // this will make it default means when no tyeps are provided default will be the message and it's object will be created and method will be called
public class SMSNotification implements Notification{
    @Override
    public void sendNotification(String message, String receiver) {

        System.out.println("Notification "+ message +" send through SMS to: " + receiver);

    }
}
