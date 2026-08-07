//package com.tss.__jpa.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tss.__jpa.dto.CourseRequestDto;
//import com.tss.__jpa.dto.CourseResponseDto;
//import com.tss.__jpa.services.CourseService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(CourseController.class)
//class CourseControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockitoBean
//    private CourseService courseService;
//
//    @Test
//    void getAllCourses() throws Exception {
//
//        CourseResponseDto course1 = new CourseResponseDto();
//        course1.setCourseId(1L);
//        course1.setCourseName("Java");
//
//        CourseResponseDto course2 = new CourseResponseDto();
//        course2.setCourseId(2L);
//        course2.setCourseName("Spring");
//
//        when(courseService.readAll())
//                .thenReturn(List.of(course1, course2));
//
//        mockMvc.perform(get("/app/course"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].courseId").value(1))
//                .andExpect(jsonPath("$[0].courseName").value("Java"))
//                .andExpect(jsonPath("$[1].courseId").value(2))
//                .andExpect(jsonPath("$[1].courseName").value("Spring"));
//
//        verify(courseService).readAll();
//    }
//
//    @Test
//    void addCourse() throws Exception {
//
//        CourseRequestDto request = new CourseRequestDto();
//        request.setCourseName("Java");
//
//        CourseResponseDto response = new CourseResponseDto();
//        response.setCourseId(1L);
//        response.setCourseName("Java");
//
//        when(courseService.addCourse(any(CourseRequestDto.class)))
//                .thenReturn(response);
//
//        mockMvc.perform(post("/app/course")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.courseId").value(1))
//                .andExpect(jsonPath("$.courseName").value("Java"));
//
//        verify(courseService).addCourse(any(CourseRequestDto.class));
//    }
//}