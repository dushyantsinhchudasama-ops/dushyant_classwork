package com.tss.behavioural.observer.observer;

import com.tss.behavioural.observer.model.Account;

public class SMSNotification implements Observer {

    @Override
    public void update(Account account, String message) {

        System.out.println(
                "SMS : Account No : " + account.getAccountNumber()+ " | " + message);
    }
}