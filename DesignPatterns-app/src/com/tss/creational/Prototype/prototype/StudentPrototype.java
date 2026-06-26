package com.tss.creational.Prototype.prototype;

import com.tss.creational.Prototype.model.Student;

public class StudentPrototype {

    public Student cloneStudent(Student original)
    {
        return new Student(
                original.getAge(),
                original.getEmail(),
                original.getId(),
                original.getName()
        );
    }
}
