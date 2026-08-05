package com.tss.__jpa.services;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber; // ✅ Correctimport org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("sms")
@Primary
public class SMSNotification implements Notification {

    @Value("${twilio.phone.number}")
    private String fromNumber;

    @Override
    public void sendNotification(String message, String receiver) {

        Message.creator(
                new PhoneNumber(receiver),
                new PhoneNumber(fromNumber),
                message
        ).create();
    }
}
