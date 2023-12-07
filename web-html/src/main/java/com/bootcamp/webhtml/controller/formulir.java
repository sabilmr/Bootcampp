package com.bootcamp.webhtml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/forms")
public class formulir {
    @GetMapping
    public ModelAndView style(){
        return new ModelAndView("forms/formulir");
    }
    @GetMapping("elements")
    public ModelAndView elements(){
        return new ModelAndView("forms/element");
    }
    @GetMapping("/input")
    public ModelAndView input(){
        return new ModelAndView("forms/input");
    }
    @GetMapping("/images")
    public ModelAndView images(){
        return new ModelAndView("forms/images");
    }
}
