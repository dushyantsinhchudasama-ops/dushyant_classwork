package com.tss.test;

import com.tss.account.Account;
import com.tss.comparators.NameCompartor;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int noOfAccounts;
        List<Account> account = new ArrayList<>();
        int choice = 0;
        String name;
        double balance;

        while(true)
        {
            System.out.println("How many accounts you want to create: ");

            try{
                noOfAccounts = scanner.nextInt();

                if(noOfAccounts > 0)
                    break;
                else
                    System.out.println("Invalid number");
            } catch (InputMismatchException e)
            {
                System.out.println("Please enter valid number!");
                scanner.next();
            }
        }

        while (true) {

            System.out.println();
            System.out.println("1. Add Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.println("7. Get Sorted Accounts");

            try {

                System.out.print("Enter Choice : ");
                choice = scanner.nextInt();

                switch (choice) {

                    case 1:

                        if (account.size() >= noOfAccounts) {
                            System.out.println("Maximum account limit reached.");
                            break;
                        }

                        scanner.nextLine();

                        System.out.print("Enter Name : ");
                        name = scanner.nextLine();

                        System.out.print("Enter Balance : ");
                        balance = scanner.nextDouble();

                        if (balance < 500) {
                            System.out.println("Minimum balance should be 500");
                            break;
                        }

                        Account newAccount = new Account(balance, name);
                        newAccount.setId();
                        newAccount.setAccountNumber();
                        account.add(newAccount);

                        System.out.println("Account Created Successfully");
                        System.out.println("ID : " + newAccount.getId());
                        System.out.println("Account Number : " + newAccount.getAccountNumber());

                        break;

                    case 2:

                        System.out.print("Enter Account Number : ");
                        long depositAcc = scanner.nextLong();

                        Account depAccount = findAccount(account, depositAcc);

                        if (depAccount == null) {
                            System.out.println("Account not found");
                            break;
                        }

                        System.out.print("Enter Deposit Amount : ");
                        double depAmount = scanner.nextDouble();

                        if (depAmount <= 0) {
                            System.out.println("Invalid amount");
                            break;
                        }

                        depAccount.deposite(depAmount);

                        break;

                    case 3:

                        System.out.print("Enter Account Number : ");
                        long withdrawAcc = scanner.nextLong();

                        Account withAccount = findAccount(account, withdrawAcc);

                        if (withAccount == null) {
                            System.out.println("Account not found");
                            break;
                        }

                        System.out.print("Enter Withdraw Amount : ");
                        double withdrawAmount = scanner.nextDouble();

                        if (withdrawAmount <= 0) {
                            System.out.println("Invalid amount");
                            break;
                        }

                        withAccount.withdraw(withdrawAmount);

                        break;

                    case 4:

                        System.out.print("Enter Source Account Number : ");
                        long sourceAcc = scanner.nextLong();

                        System.out.print("Enter Destination Account Number : ");
                        long destinationAcc = scanner.nextLong();

                        Account source =
                                findAccount(account, sourceAcc);

                        Account destination =
                                findAccount(account, destinationAcc);

                        if (source == null) {
                            System.out.println("Source account not found");
                            break;
                        }

                        if (destination == null) {
                            System.out.println("Destination account not found");
                            break;
                        }

                        System.out.print("Enter Amount : ");
                        double transferAmount = scanner.nextDouble();

                        source.transfer(destination, transferAmount);

                        break;

                    case 5:

                        if (account.isEmpty()) {
                            System.out.println("No accounts available.");
                            break;
                        }

                        System.out.println("----------------------------------------------------------------");
                        System.out.printf("%-10s %-20s %-20s %-15s%n",
                                "ID", "NAME", "ACCOUNT NO", "BALANCE");
                        System.out.println("----------------------------------------------------------------");

                        for (Account acc : account) {

                            System.out.printf("%-10d %-20s %-20d %-15.2f%n",
                                    acc.getId(),
                                    acc.getName(),
                                    acc.getAccountNumber(),
                                    acc.getBalance());
                        }

                        break;

                    case 6:

                        System.out.println("Thank You");

                        System.exit(0);
                        break;

                    case 7:
                        System.out.println("Sorting by name: ");
                        Collections.sort(account, new NameCompartor());
                        System.out.println(account);
                        break;


                    default:
                        System.out.println("Invalid Choice");
                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid Input!");
                scanner.next();
            }

        }

    }

    public static Account findAccount(List<Account> accounts, long accountNumber) {

        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }
}
