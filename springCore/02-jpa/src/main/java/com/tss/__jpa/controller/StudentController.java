package com.tss.__jpa.controller;

import com.tss.__jpa.dto.PageResponseDto;
import com.tss.__jpa.dto.StudentRequestDto;
import com.tss.__jpa.dto.StudentResponseDto;
import com.tss.__jpa.entity.Student;
import com.tss.__jpa.error.Error;
import com.tss.__jpa.exception.StudentNotFoundByIDException;
import com.tss.__jpa.services.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

//    @GetMapping("/students")
//    public ResponseEntity<List<StudentResponseDto>> getAll()
//    {
//        return new ResponseEntity<>(studentService.readAll(), HttpStatus.OK);
//    }

    @GetMapping("/students")
    public ResponseEntity<PageResponseDto<StudentResponseDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size ,
            @RequestParam(required = false) String name) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("App-Name","JPA Testing app");
        headers.add("Version","1.0");

        if(name == null)
            return ResponseEntity.ok(studentService.readAll(page, size));

        return ResponseEntity.ok(studentService.findStudentByName(page, size, name));
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

    @DeleteMapping("/students/{age}")
    public Integer deleteByAge(@PathVariable Integer age)
    {
        return studentService.deleteByAge(age);
    }


}
