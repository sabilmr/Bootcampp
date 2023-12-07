package com.bootcamp.webhtml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Block {
    @GetMapping("/block")
    public ModelAndView block(){
        return new ModelAndView("block/inline");
    }
    @GetMapping("/kelas")
    public ModelAndView kelas(){
        return new ModelAndView("block/kelas");
    }
    @GetMapping("/id")
    public ModelAndView id(){
        return new ModelAndView("block/id");
    }
    @GetMapping("/iframes")
    public ModelAndView iframes(){
        return new ModelAndView("block/iframes");
    }
}
