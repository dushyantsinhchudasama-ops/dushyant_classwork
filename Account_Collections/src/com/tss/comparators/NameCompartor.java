package com.tss.comparators;

import com.tss.account.Account;

import java.util.Comparator;

public class NameCompartor implements Comparator<Account> {

    @Override
    public int compare(Account account1, Account account2) {
        return account2.getName().compareTo(account1.getName());
    }
}
