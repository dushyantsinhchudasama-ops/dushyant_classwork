package com.tss.model;

public class NotificationService {

    public void sendConfirmation(String email, String confirmationNumber) {

        System.out.println("Confirmation sent to " + email + " \n Confirmation number : " + confirmationNumber);
    }
}