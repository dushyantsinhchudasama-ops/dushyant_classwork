package com.tss.__jpa.services;

import com.tss.__jpa.dto.CourseRequestDto;
import com.tss.__jpa.dto.CourseResponseDto;
import com.tss.__jpa.dto.InstructorResponseDto;
import com.tss.__jpa.entity.Course;
import com.tss.__jpa.entity.Instructor;
import com.tss.__jpa.mapper.CourseMapper;
import com.tss.__jpa.mapper.InstructorMapper;
import com.tss.__jpa.repository.CourseRepository;
import com.tss.__jpa.repository.InstructorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.processing.Find;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    @Override
    public CourseResponseDto addCourse(CourseRequestDto requestDto) {

        System.out.println("DTO = " + requestDto);

        Course course = courseMapper.toEntity(requestDto);

        System.out.println("Entity = " + course);

        System.out.println("DTO = " + requestDto);

        Course saved = courseRepository.save(course);

        System.out.println("Saved = " + saved);

        return courseMapper.toDto(saved);
    }

    @Override
    public void assignInstructure(Long courseID, Long instructorId) {



        Course course = courseRepository.findById(courseID)
                .orElseThrow(()-> new RuntimeException("Can not find course with id: " + courseID));

        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(()-> new RuntimeException("Can not find Instructor with id: " + instructorId));

        course.setInstructor(instructor);

        courseRepository.save(course);
    }

    @Override
    public InstructorResponseDto getCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new RuntimeException("Can not find course with ID : " + courseId));

        Instructor instructor = course.getInstructor();

        return instructorMapper.toDto(instructor);
    }

    @Override
    public List<CourseResponseDto> readAll() {

        List<Course> courses = courseRepository.findAll();

        List<CourseResponseDto> responses = new ArrayList<>();

        for(Course course : courses)
        {
            CourseResponseDto responseDto = new CourseResponseDto();
            responseDto.setCourseId(course.getCourseId());
            responseDto.setCourseName(course.getCourseName());
            responseDto.setDuration(course.getDuration());
            responseDto.setFees(course.getFees());
            responses.add(responseDto);
        }

        return responses;
    }
}
