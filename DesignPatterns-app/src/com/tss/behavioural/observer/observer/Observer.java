package com.tss.behavioural.observer.observer;

import com.tss.behavioural.observer.model.Account;

public interface Observer {

    void update(Account account, String message);
}