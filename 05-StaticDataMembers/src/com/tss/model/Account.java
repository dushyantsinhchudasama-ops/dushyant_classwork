package com.tss.model;

import java.util.Random;

public abstract class Account {

    private int accountId;
    private long accountNumber;
    private double balance;
    private String name;

    private static int idCounter = 1;

    public Account() {
        accountId = 0;
        accountNumber = 0;
        balance = 0.0;
        name = "Null";
    }

    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    // Setters

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountId() {
        this.accountId = idCounter++;
    }

    public void setAccountNumber() {
        Random random = new Random();
        this.accountNumber = 10000 + random.nextInt(90000);
    }

    // Getters

    public int getAccountId() {
        return accountId;
    }

    public long getAccountNumner() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }


    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void displayInfo();

    public void displayOverDraftInfo(){

    }
}