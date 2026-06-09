package com.tss.entity;

import java.util.Random;

public class Account {

    private int accountId;
    private long accountNumber;
    private double balance;
    private String name;
    private String type;
    private int idCounter;

    public Account(){
        accountId = 0;
        accountNumber = 0;
        balance = 0.0;
        name = "Null";
        type = "Default";
        idCounter = 1;
    }

    public Account(double balance, String name, String type)
    {
        this.name = name;
        this.balance = balance;
        this.type = type;
    }

    //getters and setter

    public void setBalance(double balance) {this.balance = balance; }
    public void setName(String name) {this.name = name; }
    public void setType(String type) {this.type = type; }
    public void setAccountId()
    {
        this.accountId = idCounter;
        idCounter++;
    }
    public void setAccountNumber()
    {
        Random random = new Random();

        accountNumber = random.nextLong(8);
    }

    public int getAccountId() { return accountId;}
    public long getAccountNumner() { return accountNumber;}
    public String getName() { return name;}
    public double getBalance() { return balance;}
    public String getType() { return type;}

    public void deposite(double amount)
    {
        this.balance += amount;
    }

    public void withdraw(double amount)
    {
        double currentAmount = getBalance();
        double amountTodeduct = currentAmount - amount;

        if(currentAmount < 500 || amountTodeduct < 500)
        {
            System.out.println("Minimum balance should be 500");
        }
        else {
            balance -= amount;
            System.out.println("Amount withdrawal successful");
            System.out.println("Remaining balance: " + getBalance());
        }
    }
}
