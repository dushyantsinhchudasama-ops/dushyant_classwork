package com.tss.test;

import com.tss.entity.Account;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;
        String name = "";
        String type ="";
        double balance= 0.0;


        Account account = new Account();

        System.out.println("Account ID: " + account.getAccountId());
        System.out.println("Account Numner: " + account.getAccountNumner());
        System.out.println("Account Name: " + account.getName());
        System.out.println("Account Balance: " + account.getBalance());
        System.out.println("Account Type: " + account.getType());

        while(true){
            try {
                System.out.println("Enter Name: ");
                name = scanner.nextLine();
                System.out.println("Enter Account Type: ");
                type = scanner.nextLine();
                System.out.println("Enter balance");
                balance = scanner.nextDouble();
                break;
            }catch (InputMismatchException e)
            {
                System.out.println("Enter valid choice");
            }
        }

        Account account1 = new Account(balance, name, type);
        account1.setAccountId();
        account1.setAccountNumber();

        while(true)
        {
            System.out.println("Enter \n1.For details\n2.For check Balance\n3.For Deposte\n4.For Withdraw\n5.Exit");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Account ID: " + account1.getAccountId());
                    System.out.println("Account Numner: " + account1.getAccountNumner());
                    System.out.println("Account Name: " + account1.getName());
                    System.out.println("Account Balance: " + account1.getBalance());
                    System.out.println("Account Type: " + account1.getType());
                    break;

                case 2:
                    System.out.println("Balance is: " + account1.getBalance());
                    break;

                case 3:
                    System.out.println("Enter amount to deposite");
                    try{
                        balance = scanner.nextDouble();

                        if(balance <= 0)
                        {
                            System.out.println("Enter valid amount");
                            continue;
                        }

                        account1.deposite(balance);

                    }catch (InputMismatchException e)
                    {
                        System.out.println("Please enter valid amount");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.println("Enter balance: ");
                    try {
                        balance = scanner.nextDouble();

                        if(balance <= 0)
                        {
                            System.out.println("Enter valid amount");
                            break;
                        }
                    }
                    catch (InputMismatchException e)
                        {
                            System.out.println("Please enter valid amount");
                            scanner.next();
                            break;
                        }
                    account1.withdraw(balance);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Please enter valid choice! ");
            }
        }
    }
}
