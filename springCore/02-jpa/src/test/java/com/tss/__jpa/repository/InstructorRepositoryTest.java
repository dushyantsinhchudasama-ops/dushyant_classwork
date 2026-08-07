package com.tss.__jpa.repository;

import com.tss.__jpa.dto.CountOfCourseForAllInstructors;
import com.tss.__jpa.entity.Course;
import com.tss.__jpa.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class InstructorRepositoryTest {

    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private CourseRepository courseRepository;

//    @Autowired
//    private EntityManager entityManager;

    @Test
    void getCourseCountTest() {

        // Arrange
        Instructor instructor = new Instructor();
        instructor.setName("John");

        instructor = instructorRepository.save(instructor);

        Course c1 = new Course();
        c1.setCourseName("Java");
        c1.setInstructor(instructor);

        Course c2 = new Course();
        c2.setCourseName("Spring");
        c2.setInstructor(instructor);

        courseRepository.save(c1);
        courseRepository.save(c2);

        // Act
        Integer count = instructorRepository.getCourseCount(instructor.getInstructorId());

        // Assert
        assertEquals(2, count);
    }

    @Test
    void getCourseCountPerInstructor() {

        Instructor instructor1 = new Instructor();
        instructor1.setName("John");
        instructor1 = instructorRepository.save(instructor1);

        Instructor instructor2 = new Instructor();
        instructor2.setName("David");
        instructor2 = instructorRepository.save(instructor2);

        Course course1 = new Course();
        course1.setCourseName("Java");
        course1.setInstructor(instructor1);

        Course course2 = new Course();
        course2.setCourseName("Spring");
        course2.setInstructor(instructor1);

        Course course3 = new Course();
        course3.setCourseName("Hibernate");
        course3.setInstructor(instructor2);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        // Act

        List<CountOfCourseForAllInstructors> result =
                instructorRepository.getCourseCountPerInstructor();

        // Assert

        assertEquals(2, result.size());

        CountOfCourseForAllInstructors john =
                result.stream()
                        .filter(r -> r.getName().equals("John"))
                        .findFirst()
                        .orElseThrow();

        assertEquals(2L, john.getCourseCount());

        CountOfCourseForAllInstructors david =
                result.stream()
                        .filter(r -> r.getName().equals("David"))
                        .findFirst()
                        .orElseThrow();

        assertEquals(1L, david.getCourseCount());
    }

}