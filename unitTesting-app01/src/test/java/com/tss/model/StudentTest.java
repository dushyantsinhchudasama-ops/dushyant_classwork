package com.tss.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentTest {

    Student student;
    @Mock
    IStudent iStudent;

    @BeforeEach
    void init()
    {
        student = new Student(iStudent);
    }


    @Test
    void calculateAverage() {

        Mockito.when(iStudent.getMarks()).thenReturn(900);
        Mockito.when(iStudent.getSubjects()).thenReturn(10);

        assertEquals(90,student.calculateAverage());
    }
}