package com.tss.model;

public class Account
{
    private int accountId;
    private String name;
    private String accountNo;
    private double balance;

    public Account() {
    }

    public Account(String accountNo, double balance, String name) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.name = name;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
