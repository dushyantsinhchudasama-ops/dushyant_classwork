package com.tss.__jpa.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
public class EmailNotification implements Notification{
    @Override
    public void sendNotification(String message, String receiver) {
        System.out.println("Notification "+ message +" send through email to: " + receiver);
    }
}
