package com.tss.db.menu;

import com.tss.db.database.Database;
import com.tss.db.model.Student;
import com.tss.db.repository.StudentRepository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    StudentRepository studentRepository = new StudentRepository();

    int choice;

    public void showMenu()
    {
        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    studentRepository.addStudent(scanner);
                    break;

                case 2:
                    studentRepository.getAllStudents();
                    break;

                case 3:
                    studentRepository.updateStudent(scanner);
                    break;

                case 4:
                    studentRepository.deleteStudent(scanner);
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
