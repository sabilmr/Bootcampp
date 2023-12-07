package com.bootcamp.belajarspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HomeController {

    @GetMapping
    public String ping (){
        return "ping";
    }
    @GetMapping("test")
    public String testApi(){
        return "test-Api";
    }
    @GetMapping("/ping")
    public String getPing(){
        return "test-ping";
    }
    @GetMapping("/hitung")
    public Integer getHitung(){
        return 100;
    }
    @GetMapping("/pecahan")
    public Double getPecahan(){
        return 50.50;
    }
    @GetMapping("/bool")
    public boolean getbool(){
        return true;
    }
    @GetMapping("/boolean")
    public boolean getBoolean(){
        return false;
    }



}

