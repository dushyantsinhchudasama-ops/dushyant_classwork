package com.tss.creational.Builder.test;

import com.tss.creational.Builder.builder.StudentBuilder;
import com.tss.creational.Builder.model.Student;

public class StudentTest {

    public static void main(String[] args) {

        Student student = new StudentBuilder()
                .setName("Dushyant")
                .setEmail("dushyant@mail.com")
                .setId("ABC123")
                .setAge(21)
                .build();

        System.out.println(student);
    }
}
