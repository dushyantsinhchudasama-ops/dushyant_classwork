package com.tss.__jpa.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class NotificationProcessor {

    private final Map<String, Notification> notification;

    public void send(String type, String message, String receiver)
    {
        Notification notify = notification.get(type);

        notify.sendNotification(message, receiver);
    }
}
