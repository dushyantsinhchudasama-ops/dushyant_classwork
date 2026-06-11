package com.tss.model;

public class SavingsAccount extends Account {

    public SavingsAccount() {
    }

    public SavingsAccount(String name, double balance) {
        super(balance, name);
    }

    @Override
    public void deposit(double amount) {

        setBalance(getBalance() + amount);

        System.out.println("Amount deposited successfully.");
        System.out.println("Current Balance: " + getBalance());
    }

    @Override
    public void withdraw(double amount) {

        double currentBalance = getBalance();

        if (currentBalance - amount < 500) {
            System.out.println("Minimum balance should be 500.");
            return;
        }

        setBalance(currentBalance - amount);

        System.out.println("Amount withdrawal successful.");
        System.out.println("Remaining Balance: " + getBalance());
    }

    @Override
    public void displayInfo() {

        System.out.println("Name    : " + getName());
        System.out.println("ID      : " + getAccountId());
        System.out.println("Number  : " + getAccountNumner());
        System.out.println("Balance : " + getBalance());
    }
}
