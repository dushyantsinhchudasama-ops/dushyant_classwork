package com.tss.creational.Prototype.test;

import com.tss.creational.Prototype.model.Student;
import com.tss.creational.Prototype.prototype.StudentPrototype;

public class StudentTest {

    public static void main(String[] args) {

        Student student = new Student(21,"dushyant@mail.com","ABC123","Dushyant");
        System.out.println("Original Student:");
        System.out.println(student);


        StudentPrototype prototype = new StudentPrototype();

        Student student2 = prototype.cloneStudent(student);
        System.out.println(student2);

        Student student3 = prototype.cloneStudent(student);
        System.out.println(student3);
    }
}
