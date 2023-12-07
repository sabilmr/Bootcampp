package com.bootcamp.webhtml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Home {
    @GetMapping("/home")
    public ModelAndView index(){
        return new ModelAndView("pages/home/index");
    }
    @GetMapping("/contact")
    public ModelAndView content(){
        return new ModelAndView("pages/contact/index");
    }
    @GetMapping("/about")
    public ModelAndView about(){
        return new ModelAndView("pages/about/index");
    }
}
