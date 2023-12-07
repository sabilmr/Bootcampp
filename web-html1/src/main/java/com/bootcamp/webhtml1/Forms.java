package com.bootcamp.webhtml1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Forms {
    @GetMapping("forms")
    public ModelAndView forms(){
        return new ModelAndView("forms/form");
    }
    @GetMapping("respon")
    public ModelAndView respon(){
        return new ModelAndView("forms/responsive");
    }
}
