package com.tss.db.menu;

import com.tss.db.database.Database;
import com.tss.db.model.Course;
import com.tss.db.repository.CourseRepository;
import com.tss.db.repository.StudentRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class courseMenu {

    Scanner scanner = new Scanner(System.in);

    CourseRepository courseRepository = new CourseRepository();

    int choice;

    public void showMenu()
    {
        do {

            System.out.println("\n===== COURSE MANAGEMENT =====");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    try {
                        courseRepository.addCourse(scanner);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        courseRepository.getAllCourses();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:

                    try {
                        courseRepository.updateCourse(scanner);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        courseRepository.deleteCourse(scanner);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }
}
