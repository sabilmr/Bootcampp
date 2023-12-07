package com.bootcamp.webhtml1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Home {

    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home/index");
    }
    @GetMapping("/contact")
    public ModelAndView contact(){
        return new ModelAndView("contact/index");
    }
    @GetMapping("/about")
    public  ModelAndView about(){
        return new ModelAndView("about/index");
    }
}
