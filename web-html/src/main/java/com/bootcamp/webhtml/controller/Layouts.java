package com.bootcamp.webhtml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Layouts {
    @GetMapping("/layout")
    public ModelAndView layouts(){
        return new ModelAndView("layouts/index");
    }
    @GetMapping("/respons")
    public ModelAndView respons(){
        return new ModelAndView("layouts/responsive");
    }
    @GetMapping("/computer")
    public ModelAndView computer(){
        return new ModelAndView("layouts/computer");
    }
}
