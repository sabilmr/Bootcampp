package com.bootcamp.belajarspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AlamatController{

    @GetMapping("alamat")
    public String Pandaan(){
        return "Kec.Pandaan";
    }
    @GetMapping("pasuruan")
    public String Pasuruan(){
        return "Kab.Pasuruan";
    }
    @GetMapping("jedung")
    public String Jedung(){
        return "Dusun Jedung";
    }
    @GetMapping("sebani")
    public String Sebani(){
        return "Desa Sebani";
    }
    @GetMapping("surabaya")
    public String Surabaya(){
        return "Kota Surabaya";
    }
    @GetMapping("rt rw")
    public double RtRw (){
        return 01.10;
    }
    @GetMapping("jumlah penduduk")
    public Integer Jumlah(){
        return 150;
    }

}
