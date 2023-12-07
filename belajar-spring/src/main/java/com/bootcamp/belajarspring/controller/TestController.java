package com.bootcamp.belajarspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hp")
public class TestController {

    @GetMapping("hp")
    public String hp(){
        return "hp-android";
    }
    @GetMapping("xiomi")
    public String hpXiomi(){
        return "hp Xiomi";
    }
    @GetMapping("oppo")
    public String hpOppo(){
        return "hp Oppo";
    }
    @GetMapping("samsung")
    public String hpSamsung(){
        return "HP Samsung";
    }
    @GetMapping("apple")
    public String hpApple(){
        return "Hp Apple";
    }
    @GetMapping("/redmi")
    public String hpRedmi(){
        return "Hp Redmi";
    }
    @GetMapping("/sony")
    public String hpSony(){
        return "Hp Sony";
    }
    @GetMapping("/nokia")
    public String hpNokia(){
        return "Hp Nokia";
    }
    @GetMapping("/vivo")
    public String hpVivo(){
        return "Hp Vivo";
    }
    @GetMapping("/relme")
    public String hpRelme(){
        return "Hp Relme";
    }
}
