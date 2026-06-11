
package com.tss.model;

public class CurrentAccount extends Account {

    private double overDraftLimit = 10000;
    private double overDraftUsed = 0;
    private double overDraftBalance = overDraftLimit - overDraftUsed;

    public CurrentAccount() {
    }

    public CurrentAccount(double balance, String name) {
        super(balance, name);
    }

    // Getters

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    public double getOverDraftUsed() {
        return overDraftUsed;
    }

    public double getOverDraftBalance() {
        return overDraftBalance;
    }

    // Setters

    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    public void setOverDraftUsed(double overDraftUsed) {
        this.overDraftUsed = overDraftUsed;
    }

    @Override
    public void deposit(double amount) {

        double currentBalance = getBalance();

        if (currentBalance < 0) {

            double overdraftDebt = Math.abs(currentBalance);

            if (amount >= overdraftDebt) {

                double remainingAmount = amount - overdraftDebt;

                overDraftUsed -= overdraftDebt;

                if (overDraftUsed < 0) {
                    overDraftUsed = 0;
                }

                overDraftBalance = overDraftLimit - overDraftUsed;

                setBalance(remainingAmount);

                System.out.println("Overdraft cleared.");
                System.out.println("Current Balance: " + getBalance());
            } else {

                setBalance(currentBalance + amount);

                overDraftUsed -= amount;

                if (overDraftUsed < 0) {
                    overDraftUsed = 0;
                }

                overDraftBalance = overDraftLimit - overDraftUsed;

                System.out.println("Amount adjusted against overdraft.");
                System.out.println("Current Balance: " + getBalance());
            }

        } else {

            setBalance(currentBalance + amount);

            System.out.println("Amount deposited successfully.");
            System.out.println("Current Balance: " + getBalance());
        }
    }

    @Override
    public void withdraw(double amount) {

        double currentBalance = getBalance();

        if (amount <= currentBalance) {

            setBalance(currentBalance - amount);

            System.out.println("Withdraw successful.");
            System.out.println("Current Balance: " + getBalance());

        } else {

            double overdraftRequired = amount - currentBalance;

            if (overDraftUsed + overdraftRequired <= overDraftLimit) {

                setBalance(currentBalance - amount);

                overDraftUsed += overdraftRequired;
                overDraftBalance = overDraftLimit - overDraftUsed;

                System.out.println("Withdraw successful.");
                System.out.println("Overdraft Used: " + overdraftRequired);
                System.out.println("Current Balance: " + getBalance());

            } else {

                System.out.println("Overdraft limit exceeded.");
            }
        }
    }

    @Override
    public void displayOverDraftInfo() {

        System.out.println("Account Number      : " + getAccountNumner());
        System.out.println("Account Name        : " + getName());
        System.out.println("Overdraft Limit     : " + overDraftLimit);
        System.out.println("Overdraft Used      : " + overDraftUsed);
        System.out.println("Remaining Overdraft : " + overDraftBalance);
    }

    @Override
    public void displayInfo() {

        System.out.println("Name    : " + getName());
        System.out.println("ID      : " + getAccountId());
        System.out.println("Number  : " + getAccountNumner());
        System.out.println("Balance : " + getBalance());
    }
}