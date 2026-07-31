package com.tss.__jpa.controller;

import com.tss.__jpa.dto.*;
import com.tss.__jpa.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @GetMapping("/course")
    public ResponseEntity<List<CourseResponseDto>> getAll()
    {
        return new ResponseEntity<>(courseService.readAll(), HttpStatus.OK);
    }

    @PostMapping("/course")
    public ResponseEntity<CourseResponseDto> addCourse(@RequestBody CourseRequestDto requestDto)
    {
        return new ResponseEntity<>(courseService.addCourse(requestDto), HttpStatus.CREATED);
    }

    @PostMapping("/course/{courseId}/instructor/{instructorId}")
    public ResponseEntity<Void> assignInstructor(@PathVariable Long courseId, @PathVariable Long instructorId)
    {
        courseService.assignInstructure(courseId, instructorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //get courses for particular instructor
    @GetMapping("/course/{courseId}/instructor/")
    public ResponseEntity<InstructorResponseDto> getInstructure(@PathVariable Long courseId)
    {
        return ResponseEntity.ok(courseService.getCourse(courseId));
    }


    //assigning student to a course
    @PostMapping("/course/{courseId}/student/{studentId}")
    public ResponseEntity<Void> assignStudent(@PathVariable Long courseId,@PathVariable Long studentId)
    {
        courseService.assignStudent(courseId, studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/course/{courseId}/students")
    public ResponseEntity<List<StudentResponseDto>> getAllStudentByCourseID(@PathVariable Long courseId)
    {
        return ResponseEntity.ok(courseService.getAllStudentsByID(courseId));
    }

}