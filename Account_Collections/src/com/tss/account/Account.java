package com.tss.account;

import java.util.Random;

public class Account implements Comparable<Account> {

    private int id;
    private long accountNumber;
    private String name;
    private double balance;
    private int idCounter = 1;

    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void setAccountNumber() {
        Random random = new Random();
        long accno = random.nextInt(12345);
        accno *= 1;
        this.accountNumber = accno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = idCounter;
        idCounter++;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposite(double amount)
    {
        balance += amount;
        System.out.println("Amount deposited! Current balance: " + getBalance());
    }

    public void withdraw(double amount)
    {
        if((balance - amount) < 500)
        {
            System.out.println("Minimim balance limit reached");
        }
        else {
            balance -= amount;
            System.out.println("Amount withdraw! Current balance: " + getBalance());
        }
    }

    public void transfer(Account destination, double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        if ((balance - amount) < 500) {
            System.out.println("Minimum balance should remain 500");
            return;
        }

        this.balance -= amount;
        destination.balance += amount;

        System.out.println("Transfer Successful");
        System.out.println("Source Balance : " + this.balance);
        System.out.println("Destination Balance : " + destination.balance);
    }


    @Override
    public int compareTo(Account account) {
        return (int)(this.id - account.id);
    }
}
