package com.bootcamp.webhtml.controller;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Tabel {

    @GetMapping("/table")
    public ModelAndView table(){
        return new ModelAndView("table/tabel");
    }
}
