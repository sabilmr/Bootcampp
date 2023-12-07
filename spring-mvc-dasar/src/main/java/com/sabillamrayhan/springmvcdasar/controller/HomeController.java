package com.sabillamrayhan.springmvcdasar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "pages/home/index";
    }

    @GetMapping("/dasboard")
    public String dasboard(){
        return "pages/home/dasboard";
    }

}
