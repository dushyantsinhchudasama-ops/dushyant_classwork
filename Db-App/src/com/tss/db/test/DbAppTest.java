package com.tss.db.test;

import com.tss.db.database.Database;
import com.tss.db.menu.EnrollmentMenu;
import com.tss.db.menu.Menu;
import com.tss.db.menu.courseMenu;
import com.tss.db.model.Student;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.util.Scanner;

public class DbAppTest {
    public static void main(String[] args) {

        showMenu();
    }

    public static void showMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while(true) {
            System.out.println("Enter \n1.For Student Management \n2.For Courses Management\n3. For Enrollment Management\n4.For Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Menu menu = new Menu();
                    menu.showMenu();
                    break;

                case 2:
                    courseMenu courseMenu = new courseMenu();
                    courseMenu.showMenu();
                    break;

                case 3:
                    EnrollmentMenu enrollmentMenu = new EnrollmentMenu();
                    enrollmentMenu.showMenu();
                    break;

                case 4:
                    System.out.println("Thank you");
                    return;

                default:
                    System.out.println("Please enter valid menu choice");

            }
        }
    }
}
