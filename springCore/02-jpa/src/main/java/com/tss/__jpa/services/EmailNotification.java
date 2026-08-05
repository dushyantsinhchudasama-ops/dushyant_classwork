package com.tss.__jpa.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.ReflectiveScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("email")
@RequiredArgsConstructor
public class EmailNotification implements Notification{

    private final JavaMailSender javaMailSender;

    @Override
    public void sendNotification(String message, String receiver) {

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("dushyant.testspring@gmail.com");
            mailMessage.setTo(receiver);
            mailMessage.setSubject("OTP FOR YOUR ACCOUNT");
            mailMessage.setText(message);

            javaMailSender.send(mailMessage);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


//    @Override
//    public void sendNotification(String message, String receiver) {
//        System.out.println("Notification "+ message +" send through email to: " + receiver);
//    }



}
