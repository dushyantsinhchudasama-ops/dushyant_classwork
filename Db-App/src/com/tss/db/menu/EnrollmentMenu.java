package com.tss.db.menu;

import com.tss.db.database.Database;
import com.tss.db.repository.EnrollmentRepository;
import com.tss.db.repository.StudentRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class EnrollmentMenu {

    Scanner scanner = new Scanner(System.in);

    EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

    int choice;

    public void showMenu()
    {
        do {

            System.out.println("\n===== ENROLLMENT MANAGEMENT =====");
            System.out.println("1. Add Enrollment");
            System.out.println("2. View All Enrollments");
            System.out.println("3. Update Enrollment");
            System.out.println("4. Delete Enrollment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    try {
                        enrollmentRepository.addEnrollment(scanner);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        enrollmentRepository.getAllEnrollments();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:

                    try {
                        enrollmentRepository.updateEnrollment(scanner);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        enrollmentRepository.deleteEnrollment(scanner);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    Database.closeConnection();
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }
}
