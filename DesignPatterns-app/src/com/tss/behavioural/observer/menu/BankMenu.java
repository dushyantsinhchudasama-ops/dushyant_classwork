package com.tss.behavioural.observer.menu;

import com.tss.behavioural.observer.model.Account;
import com.tss.behavioural.observer.observer.*;

import java.util.Scanner;

public class BankMenu {

    Scanner scanner = new Scanner(System.in);

    private Account account;

    public void start() {

        createAccount();

        int choice;

        do {

            System.out.println("\n====== MENU ======");
            System.out.println("1. Credit");
            System.out.println("2. Debit");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    creditAmount();
                    break;

                case 2:
                    debitAmount();
                    break;

                case 3:
                    System.out.println(
                            "Balance = "
                                    + account.getBalance()
                    );
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);
    }

    private void createAccount() {

        System.out.print("Enter Name : ");
        String name = scanner.next();

        System.out.print("Enter Account Number : ");
        long accountNo = scanner.nextLong();

        System.out.print("Enter Initial Balance : ");
        double balance = scanner.nextDouble();

        account = new Account(name,accountNo,balance);

        addNotifications();
    }

    private void addNotifications() {

        System.out.println();

        System.out.println("1. SMS");
        System.out.println("2. EMAIL");
        System.out.println("3. WHATSAPP");
        System.out.println("4. ALL");

        System.out.print("How many notifiers? ");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                account.addObserver( new SMSNotification());
                break;

            case 2:
                account.addObserver(new EmailNotification());
                break;

            case 3:
                account.addObserver(new WappNotification());
                break;

            case 4:

                account.addObserver(new SMSNotification());

                account.addObserver(new EmailNotification());

                account.addObserver(new WappNotification());

                break;

            default:
                System.out.println("No Notification Added");
        }
    }

    private void creditAmount() {

        System.out.print("Enter Amount : ");

        double amount = scanner.nextDouble();

        account.credit(amount);
    }

    private void debitAmount() {

        System.out.print("Enter Amount : ");

        double amount = scanner.nextDouble();

        account.debit(amount);
    }
}