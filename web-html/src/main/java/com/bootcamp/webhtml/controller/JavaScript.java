package com.bootcamp.webhtml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class JavaScript {
    @GetMapping("/java")
    public ModelAndView java(){
        return new ModelAndView("javascript/index");
    }
}
