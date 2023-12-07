package com.example.springdemo02.controller;

import com.example.springdemo02.model.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/greeting")
public class StudentController {
    private static final List<StudentDto> STUDENT_DTOS = Arrays.asList(
            new StudentDto(1,"Sabilla Muhammad Rayhan"),
            new StudentDto(2,"Sindi Sevianti"),
            new StudentDto(3,"Anna Smith")
    );
    @GetMapping( "/{id}")
    public StudentDto getStudent(@PathVariable("id") Integer id){
        return STUDENT_DTOS.stream()
                .filter(studentDto -> id.equals(studentDto.getId()))
                .findFirst().orElseThrow(() -> new IllegalStateException("student"+ id +"does not exists"));
    }
}
