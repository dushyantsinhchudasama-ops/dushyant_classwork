package com.tss.__jpa.controller;

import com.tss.__jpa.dto.*;
import com.tss.__jpa.entity.Student;
import com.tss.__jpa.error.Error;
import com.tss.__jpa.exception.StudentNotFoundByIDException;
import com.tss.__jpa.services.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
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


    @GetMapping("student/{id}/address")
    public ResponseEntity<AddressResponseDto> getAddress(@PathVariable Long id)
    {
        return ResponseEntity.ok(studentService.getAddress(id));
    }

    @PostMapping("student/{id}/address")
    public ResponseEntity<AddressResponseDto> addAddress(
            @PathVariable Long id,
            @RequestBody AddressRequestDto requestDto)
    {
        return ResponseEntity.ok(studentService.addAddress(id, requestDto));
    }
   @PutMapping("student/{id}/address")
    public ResponseEntity<AddressResponseDto> updateAddress(
            @PathVariable Long id,
            @RequestBody AddressRequestDto requestDto)
    {
        return ResponseEntity.ok(studentService.udpateAddress(id, requestDto));
    }

    //assigning a course to a student
    @PostMapping("student/{studentId}/course/{courseId}")
    public ResponseEntity<Void> assignCourse(@PathVariable Long studentId, @PathVariable Long courseId)
    {
        studentService.assignCourse(studentId, courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //assigning multiple courses to a student
    @PostMapping("student/{studentId}/courses")
    public ResponseEntity<Void> assignMultipleCourse(@PathVariable Long studentId, @RequestBody List<Long> courseId)
    {
        studentService.assignCourses(studentId, courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //read all courses of a student
    @GetMapping("/student/{studentId}/courses")
    public ResponseEntity<List<CourseResponseDto>> readAllCoursesById(@PathVariable Long studentId)
    {
        return ResponseEntity.ok(studentService.getAllCourseByID(studentId));
    }



}
