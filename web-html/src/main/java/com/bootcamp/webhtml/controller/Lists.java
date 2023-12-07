package com.bootcamp.webhtml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Lists {

    @GetMapping("/lists")
    public ModelAndView lists(){
        return new ModelAndView("lists/list");
    }
    @GetMapping("/ordered")
    public ModelAndView ordered(){
        return new ModelAndView("lists/ordered");
    }
}
