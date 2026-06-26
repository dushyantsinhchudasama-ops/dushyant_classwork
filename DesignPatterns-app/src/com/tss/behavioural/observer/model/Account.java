package com.tss.behavioural.observer.model;

import com.tss.behavioural.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String name;
    private long accountNumber;
    private double balance;

    private List<Observer> observers = new ArrayList<>();

    public Account(String name, long accountNumber,double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {

        for (Observer observer : observers) {
            observer.update(this, message);
        }
    }

    public void credit(double amount) {

        balance += amount;

        notifyObservers("Rs." + amount + " credited. Balance = " + balance);
    }

    public void debit(double amount) {

        if (amount > balance) {

            notifyObservers("Insufficient Balance.");

            return;
        }

        balance -= amount;

        notifyObservers(
                "Rs." + amount + " debited. Balance = " + balance
        );
    }

    public String getName() {
        return name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
