package com.tss.__jpa.services;

import org.springframework.stereotype.Service;

@Service("whatsapp")
public class WhatsappNotification implements Notification{
    @Override
    public void sendNotification(String message, String receiver) {

        System.out.println("Notification "+ message +" send through WhatsApp to: " + receiver);
    }
}
