package com.tss.__jpa.services;

import com.tss.__jpa.dto.CourseResponseDto;
import com.tss.__jpa.dto.InstructorRequestDto;
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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class InstructorServiceImpl implements InstructorService{

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public InstructorResponseDto addInstructor(InstructorRequestDto requestDto) {

        Instructor instructor = instructorMapper.toEntity(requestDto);

        Instructor saved = instructorRepository.save(instructor);

        return instructorMapper.toDto(saved);
    }

    @Override
    public void assignCourse(Long instructorId, Long courseId) {

        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found with ID: " + instructorId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

        course.setInstructor(instructor);

        courseRepository.save(course);
    }

    //get courses for particular instructor
    @Override
    public List<CourseResponseDto> getCourse(Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(()-> new RuntimeException("Instructor not found with ID: " + instructorId));

        return instructor.getCourses()
                .stream()
                .map(courseMapper::toDto)
                .toList();
    }

    @Override
    public List<InstructorResponseDto> readAll() {

        List<Instructor> instructors = instructorRepository.findAll();
        List<InstructorResponseDto> responses = new ArrayList<>();

        for(Instructor instructor : instructors)
        {
            InstructorResponseDto dto = new InstructorResponseDto();
            dto.setInstructorId(instructor.getInstructorId());
            dto.setName(instructor.getName());
            dto.setQualification(instructor.getQualification());
            responses.add(dto);
        }

        return responses;
    }
}
