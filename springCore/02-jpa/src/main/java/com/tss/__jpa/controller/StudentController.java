package com.tss.__jpa.controller;

import com.tss.__jpa.dto.StudentRequestDto;
import com.tss.__jpa.dto.StudentResponseDto;
import com.tss.__jpa.entity.Student;
import com.tss.__jpa.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDto>> getAll()
    {
        return new ResponseEntity<>(studentService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public Student getByID(@PathVariable Long id)
    {
        return studentService.getById(id);
    }

    @PostMapping("/student")
    public ResponseEntity<StudentResponseDto> addStudent(@RequestBody StudentRequestDto requestDto)
    {
//        return ResponseEntity.status(CREATED).body(studentService.addStudent(student));
        return new ResponseEntity<>(studentService.addStudent(requestDto), HttpStatus.CREATED);
    }
}
