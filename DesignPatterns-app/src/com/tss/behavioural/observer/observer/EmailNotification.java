package com.tss.behavioural.observer.observer;

import com.tss.behavioural.observer.model.Account;

public class EmailNotification implements Observer {

    @Override
    public void update(Account account, String message) {

        System.out.println(
                "EMAIL: Account No : " + account.getAccountNumber() + " | " + message
        );
    }
}