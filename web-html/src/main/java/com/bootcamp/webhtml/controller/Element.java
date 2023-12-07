package com.bootcamp.webhtml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/element")
public class Element {
    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("pages/element/attribute");
    }
    @GetMapping("/style")
    public ModelAndView style(){
        return new ModelAndView("pages/element/sytle");
    }
    @GetMapping("/formatting")
    public ModelAndView pemformatan(){
        return new ModelAndView("pages/element/pemformatan");
    }
}
