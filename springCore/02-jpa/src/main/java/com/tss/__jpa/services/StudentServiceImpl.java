package com.tss.__jpa.services;

import com.tss.__jpa.dto.StudentRequestDto;
import com.tss.__jpa.dto.StudentResponseDto;
import com.tss.__jpa.entity.Employee;
import com.tss.__jpa.entity.Student;
import com.tss.__jpa.mapper.StudentMapper;
import com.tss.__jpa.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentResponseDto> readAll() {

        List<Student> students = studentRepository.findAll();
        List<StudentResponseDto> response = new ArrayList<>();

        for(Student student : students)
        {
            StudentResponseDto dto = new StudentResponseDto();
            dto.setId(student.getId());
            dto.setName(student.getName());

            response.add(dto);
        }
        return response;
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ID Does not found!")
        );
    }

    @Override
    public StudentResponseDto addStudent(StudentRequestDto requestDto)
    {
//        Student student = new Student();
//        student.setName(requestDto.getName());
//        student.setAge(requestDto.getAge());

        Student student = studentMapper.toStudentDto(requestDto);

        Student result = studentRepository.save(student);

//        StudentResponseDto responseDto = new StudentResponseDto();
//        responseDto.setId(result.getId());
//        responseDto.setName(result.getName());

        return studentMapper.responseDtoToStudent(student);
    }
}
