package com.tss.__jpa.services;

import com.tss.__jpa.dto.*;
import com.tss.__jpa.entity.Address;
import com.tss.__jpa.entity.Student;
import com.tss.__jpa.exception.AddressAlreadyExistsException;
import com.tss.__jpa.exception.AddressNotFoundException;
import com.tss.__jpa.exception.StudentNotFoundByIDException;
import com.tss.__jpa.mapper.StudentMapper;
import com.tss.__jpa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

//    @Override
//    public List<StudentResponseDto> readAll() {
//
//        List<Student> students = studentRepository.findAll();
//        List<StudentResponseDto> response = new ArrayList<>();
//
//        for(Student student : students)
//        {
//            StudentResponseDto dto = new StudentResponseDto();
//            dto.setId(student.getId());
//            dto.setName(student.getName());
//
//            response.add(dto);
//        }
//        return response;
//    }

    @Override
    public PageResponseDto<StudentResponseDto> readAll(int page, int size) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("id").ascending());

        Page<Student> studentPage = studentRepository.findAll(pageable);

        PageResponseDto<StudentResponseDto> response = new PageResponseDto<>();

        response.setContent(
                studentPage.getContent()
                        .stream()
                        .map(studentMapper::responseDtoToStudent)
                        .toList()
        );

        response.setPageNumber(studentPage.getNumber());
        response.setPageSize(studentPage.getSize());
        response.setTotalElements(studentPage.getTotalElements());
        response.setTotalPages(studentPage.getTotalPages());
        response.setFirst(studentPage.isFirst());
        response.setLast(studentPage.isLast());
        response.setHasNext(studentPage.hasNext());
        response.setHasPrevious(studentPage.hasPrevious());

        return response;
    }


    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new StudentNotFoundByIDException(id)
        );
    }

    @Override
    public StudentResponseDto addStudent(StudentRequestDto requestDto)
    {
//        Student student = new Student();
//        student.setName(requestDto.getName());
//        student.setAge(requestDto.getAge());

        Student student = studentMapper.toStudentDto(requestDto);

        Address address = new Address();
        address.setState(requestDto.getState());
        address.setCity(requestDto.getCity());
        address.setPincode(requestDto.getPincode());

        student.setAddress(address);

        Student result = studentRepository.save(student);

//        StudentResponseDto responseDto = new StudentResponseDto();
//        responseDto.setId(result.getId());
//        responseDto.setName(result.getName());

        return studentMapper.responseDtoToStudent(result);
    }

    @Override
    public PageResponseDto<StudentResponseDto> findStudentByName(int page, int size, String name) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("name").ascending());

        Page<Student> studentPage = studentRepository.findByName(name, pageable);

        PageResponseDto<StudentResponseDto> response = new PageResponseDto<>();

        response.setContent(
                studentPage.getContent()
                        .stream()
                        .map(studentMapper::responseDtoToStudent)
                        .toList()
        );

        response.setPageNumber(studentPage.getNumber());
        response.setPageSize(studentPage.getSize());
        response.setTotalElements(studentPage.getTotalElements());
        response.setTotalPages(studentPage.getTotalPages());
        response.setFirst(studentPage.isFirst());
        response.setLast(studentPage.isLast());
        response.setHasNext(studentPage.hasNext());
        response.setHasPrevious(studentPage.hasPrevious());

        return response;
    }

    @Override
    @Transactional
    public Integer deleteByAge(Integer age) {
        return studentRepository.deleteByAge(age);
    }

    @Override
    public AddressResponseDto getAddress(Long id) {

        //first find student by id
        Student student = getById(id);

        if(student.getAddress() == null)
            throw new AddressNotFoundException(id);

        return studentMapper.addressToResponseDto(student.getAddress());
    }

    @Override
    public AddressResponseDto addAddress(Long id, AddressRequestDto requestDto) {
        Student student = getById(id);

        if(student == null)
            throw new StudentNotFoundByIDException(id);

        if (student.getAddress() != null) {
            throw new AddressAlreadyExistsException();
        }


        Address address = studentMapper.requestDtoToAddress(requestDto);

        student.setAddress(address);

        Student savedStudent = studentRepository.save(student);

        return studentMapper.addressToResponseDto(savedStudent.getAddress());

    }

    @Override
    public AddressResponseDto udpateAddress(Long id, AddressRequestDto requestDto) {
        Student student = getById(id);

        if(student == null)
            throw new StudentNotFoundByIDException(id);

        Address address = student.getAddress();

        address.setState(requestDto.getState());
        address.setCity(requestDto.getCity());
        address.setPincode(requestDto.getPincode());

        Student savedStudent = studentRepository.save(student);

        return studentMapper.addressToResponseDto(savedStudent.getAddress());

    }
}
