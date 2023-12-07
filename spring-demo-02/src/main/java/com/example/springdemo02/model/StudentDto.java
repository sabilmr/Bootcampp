package com.example.springdemo02.model;
public class StudentDto {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StudentDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
