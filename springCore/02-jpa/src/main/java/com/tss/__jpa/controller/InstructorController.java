package com.tss.__jpa.controller;

import com.tss.__jpa.dto.CourseRequestDto;
import com.tss.__jpa.dto.CourseResponseDto;
import com.tss.__jpa.dto.InstructorRequestDto;
import com.tss.__jpa.dto.InstructorResponseDto;
import com.tss.__jpa.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/instructor")
    public ResponseEntity<List<InstructorResponseDto>> getAll()
    {
        return new ResponseEntity<>(instructorService.readAll(), HttpStatus.OK);
    }

    @PostMapping("/instructor")
    public ResponseEntity<InstructorResponseDto> addCourse(@RequestBody InstructorRequestDto requestDto)
    {
        return new ResponseEntity<>(instructorService.addInstructor(requestDto), HttpStatus.CREATED);
    }

    @PostMapping("/instructor/{instructorId}/course/{courseId}")
    public ResponseEntity<Void> addCourse(@PathVariable Long instructorId, @PathVariable Long courseId)
    {
        instructorService.assignCourse(instructorId, courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //get courses for particular instructor
    @GetMapping("/instructor/{instructorId}/course/")
    public ResponseEntity<List<CourseResponseDto>> getCourses(@PathVariable Long instructorId)
    {
        return ResponseEntity.ok(instructorService.getCourse(instructorId));
    }

}
