package com.tss.__jpa.services;

import com.tss.__jpa.entity.Course;
import com.tss.__jpa.entity.Instructor;
import com.tss.__jpa.repository.CourseRepository;
import com.tss.__jpa.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstructorServiceImplTest {

    @Mock
    private InstructorRepository instructorRepository;
    @Mock
    private CourseRepository courseRepository;
    @InjectMocks
    private InstructorServiceImpl instructorService;

    //check can delete instructor with zero course
    @Test
    void canDeleteInstructorWithZeroCourse() {

        when(instructorRepository.getCourseCount(1L)).thenReturn(0);

        assertTrue(instructorService.canDeleteInstructor(1L));
    }

    //can delete instructor with multiple course
    @Test
    void canDeleteInstructorWithMultipleCourse()
    {
        when(instructorRepository.getCourseCount(1L)).thenReturn(5);

        assertFalse(instructorService.canDeleteInstructor(1L));
    }

    @Test
    void assignCourse() {

        //first create dummy classes

        Instructor instructor = new Instructor();
        instructor.setInstructorId(1L);
        instructor.setName("John");

        Course course = new Course();
        course.setCourseId(100L);
        course.setCourseName("Java");

        when(instructorRepository.findById(1L)).thenReturn(Optional.of(instructor));

        when(courseRepository.findById(100L)).thenReturn(Optional.of(course));

        instructorService.assignCourse(instructor.getInstructorId(), course.getCourseId());

        assertEquals(instructor.getInstructorId(), course.getInstructor());
    }
}