package com.tss.__jpa.repository;

import com.tss.__jpa.dto.CountOfCourseForAllInstructors;
import com.tss.__jpa.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    //custome queries using jpql to get result in single query instead of hibernet fires multiple queries

    @Query("SELECT COUNT(*) FROM Course c WHERE c.instructor.instructorId=:instructorId")
    Integer getCourseCount(Long instructorId);

    //get course count for all instructors
    @Query(
            """
            SELECT new com.tss.__jpa.dto.CountOfCourseForAllInstructors(
               i.name,
               COUNT(c)
            )
            FROM Course c
            JOIN c.instructor i
            GROUP BY i.name
            """
    )
    List<CountOfCourseForAllInstructors> getCourseCountPerInstructor();
}
