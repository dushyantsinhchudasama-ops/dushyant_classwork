package com.tss.db.repository;

import com.tss.db.database.Database;
import com.tss.db.model.Course;
import com.tss.db.model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CourseRepository {

    private Connection connection;

    public CourseRepository() {
        connection = Database.getConnection();
    }

    public void getAllCourses() throws SQLException {

        List<Course> courses = Database.readAllCourses();

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-15s %-30s %-15s %-15s%n",
                "COURSE NAME", "CODE", "DESCRIPTION", "DURATION", "MAX STUDENTS");
        System.out.println("----------------------------------------------------------------------------------------------");

        for (Course course : courses) {

            System.out.printf("%-20s %-15s %-30s %-15d %-15d%n",
                    course.getCourse_name(),
                    course.getCourse_code(),
                    course.getDescription(),
                    course.getDuration_months(),
                    course.getMax_students());
        }

        System.out.println("----------------------------------------------------------------------------------------------");
    }

    //for updating student
    public void updateCourse(Scanner scanner) throws SQLException {

        System.out.print("Enter Course Code: ");
        String code = scanner.next();

        scanner.nextLine();

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter New Duration(In Months) : ");
        int duration = scanner.nextInt();

        System.out.print("Enter New Max Students : ");
        int max_students = scanner.nextInt();

        Course course = new Course(code, name, description, duration, max_students);

        Database.updateCourse(course);
    }

    //for adding new student
    public void addCourse(Scanner scanner) throws SQLException {

        System.out.print("Enter Code: ");
        String code = scanner.next();

        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Description: ");
        String descriptio  = scanner.nextLine();

        System.out.print("Enter Duration(Months) : ");
        int duration = scanner.nextInt();

        System.out.print("Enter Max students: ");
        int max_students = scanner.nextInt();

        Course course = new Course(code, name, descriptio, duration, max_students);

        Database.addNewCourse(course);
    }

    //for deleting student
    public void deleteCourse(Scanner scanner) throws SQLException {
        System.out.print("Enter Course Code : ");
        String code = scanner.next();

        Database.deleteCourse(code);
    }
}
