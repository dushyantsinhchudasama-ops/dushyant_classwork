package com.tss.db.repository;

import com.tss.db.database.Database;
import com.tss.db.model.Enrollment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EnrollmentRepository {

    private Connection connection;

    public EnrollmentRepository() {
        connection = Database.getConnection();
    }

    public void getAllEnrollments() throws SQLException {

        List<Enrollment> enrollments = Database.readAllEnrollments();

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-8s %-10s %-20s %-15s %-25s %-15s %-12s%n",
                "ID", "STU ID", "STUDENT NAME", "COURSE CODE",
                "COURSE NAME", "DATE", "STATUS");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        for (Enrollment enrollment : enrollments) {

            System.out.printf("%-8d %-10d %-20s %-15s %-25s %-15s %-12s%n",
                    enrollment.getEnrollmentId(),
                    enrollment.getStudentId(),
                    enrollment.getStudentName(),
                    enrollment.getcourseCode(),
                    enrollment.getCourseName(),
                    enrollment.getEnrollmentDate(),
                    enrollment.getStatus());
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------");
    }

    public void addEnrollment(Scanner scanner) throws SQLException {

        StudentRepository studentRepository = new StudentRepository();
        studentRepository.getAllStudents();

        System.out.print("Student ID : ");
        int studentId = scanner.nextInt();

        CourseRepository courseRepository = new CourseRepository();
        courseRepository.getAllCourses();

        scanner.nextLine();

        System.out.print("Course Code : ");
        String courseCode = scanner.next();

        scanner.nextLine();

        System.out.print("Status : ");
        String status = scanner.nextLine();

        Enrollment enrollment =
                new Enrollment(studentId, courseCode, status);

        Database.addEnrollment(enrollment);
    }

    public void updateEnrollment(Scanner scanner)
            throws SQLException {

        System.out.print("Enrollment ID : ");
        int enrollmentId = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Status : ");
        String status = scanner.nextLine();

        Enrollment enrollment = new Enrollment();

        enrollment.setEnrollmentId(enrollmentId);
        enrollment.setStatus(status);

        Database.updateEnrollment(enrollment);
    }

    public void deleteEnrollment(Scanner scanner)
            throws SQLException {

        System.out.print("Enrollment ID : ");

        int id = scanner.nextInt();

        Database.deleteEnrollment(id);
    }
}