package com.tss.db.repository;

import com.tss.db.database.Database;
import com.tss.db.model.Student;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class StudentRepository {

    private Connection connection;

    public StudentRepository() {
        connection = Database.getConnection();
    }

    public void getAllStudents()
    {

        List<Student> students = Database.readAllStudent();

        System.out.println("--------------------------------------");
        System.out.printf("%-10s %-20s %-10s%n", "ID", "NAME", "AGE");
        System.out.println("--------------------------------------");

        for (Student student : students) {

            System.out.printf("%-10d %-20s %-10d%n",
                    student.getStudent_id(),
                    student.getName(),
                    student.getAge());
        }
    }

    //for updating student
    public void updateStudent(Scanner scanner) {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter New Name: ");
        String name = scanner.next();

        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();

        Student student = new Student(id, name, age);

        Database.updateStudent(student);
    }

    //for adding new student
    public void addStudent(Scanner scanner) {

        System.out.print("Enter Name: ");
        String name = scanner.next();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        Student student = new Student(name, age);

        Database.addNewStudent(student);
    }

    //for deleting student
    public void deleteStudent(Scanner scanner)
    {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        Database.deleteStudent(id);
    }
}
