package com.tss.test;

import com.tss.model.Account;
import com.tss.model.CurrentAccount;
import com.tss.model.SavingsAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountTest {

    static Account savingsAccount;
    static Account currentAccount;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name;
        double balance;
        int choice;

        while (true) {

            System.out.println("Enter");
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");

            try {

                choice = scanner.nextInt();

                if (choice == 1 || choice == 2) {
                    break;
                }

                System.out.println("Enter a valid choice.");

            } catch (InputMismatchException e) {

                System.out.println("Enter a valid choice.");
                scanner.next();
            }
        }

        switch (choice) {

            case 1:

                scanner.nextLine();

                System.out.print("Enter Name: ");
                name = scanner.nextLine();

                System.out.print("Enter Balance: ");
                balance = scanner.nextDouble();

                savingsAccount = new SavingsAccount(name, balance);

                savingsAccount.setAccountId();
                savingsAccount.setAccountNumber();

                getSavingsAccount();
                break;

            case 2:

                scanner.nextLine();

                System.out.print("Enter Name: ");
                name = scanner.nextLine();

                System.out.print("Enter Balance: ");
                balance = scanner.nextDouble();

                currentAccount = new CurrentAccount(balance, name);

                currentAccount.setAccountId();
                currentAccount.setAccountNumber();

                getCurrentAccount();
                break;
        }
    }


    private static void getSavingsAccount() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Account Information");
            System.out.println("5. Exit");

            int choice;

            try {

                choice = scanner.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Enter a valid choice.");
                scanner.next();
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.println(
                            "Current Balance: " + savingsAccount.getBalance());
                    break;

                case 2:

                    try {

                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();

                        if (amount > 0) {
                            savingsAccount.withdraw(amount);
                        } else {
                            System.out.println("Invalid amount.");
                        }

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid amount.");
                        scanner.next();
                    }

                    break;

                case 3:

                    try {

                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();

                        if (amount > 0) {
                            savingsAccount.deposit(amount);
                        } else {
                            System.out.println("Invalid amount.");
                        }

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid amount.");
                        scanner.next();
                    }

                    break;

                case 4:

                    savingsAccount.displayInfo();
                    break;

                case 5:

                    return;

                default:

                    System.out.println("Enter a valid choice.");
            }
        }
    }


    private static void getCurrentAccount() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Overdraft Information");
            System.out.println("5. Account Information");
            System.out.println("6. Exit");

            int choice;

            try {

                choice = scanner.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Enter a valid choice.");
                scanner.next();
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.println(
                            "Current Balance: " + currentAccount.getBalance());
                    break;

                case 2:

                    try {

                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();

                        if (amount > 0) {
                            currentAccount.withdraw(amount);
                        } else {
                            System.out.println("Invalid amount.");
                        }

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid amount.");
                        scanner.next();
                    }

                    break;

                case 3:

                    try {

                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();

                        if (amount > 0) {
                            currentAccount.deposit(amount);
                        } else {
                            System.out.println("Invalid amount.");
                        }

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid amount.");
                        scanner.next();
                    }

                    break;

                case 4:

                    currentAccount.displayOverDraftInfo();
                    break;

                case 5:

                    currentAccount.displayInfo();
                    break;

                case 6:

                    return;

                default:

                    System.out.println("Enter a valid choice.");
            }
        }
    }
}

