package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hp")
public class HpController {

//Sabilla Muhammad Rayhan
//Dusun Jedung-Desa Sebani
//Kecamatan.Pandaan Kabupaten.Pasuruan

    @GetMapping("/data")
    public Product getData(){
        return new Product(1,"Oppo","Android", 4_000_000,100);
    }
    @GetMapping("/data1")
    public Product getData1(){
        return new Product(2, "Samsung", "Android",5_000_000, 100);
    }
    @GetMapping("/data2")
    public Product getData2(){
        return new Product(3,"Xiaomi","Android",3_000_000,150);
    }
    @GetMapping("/data3")
    public Product getData3(){
        return new Product(4, "Sony", "Android",2_000_000, 20);
    }
    @GetMapping("/data4")
    public Product getData4(){
        return new Product(5, "Aplle", "IOS",10_000_000,200);
    }
    @GetMapping("/data5")
    public Product getData5(){
        return new Product(6, "Vivo", "Android",5_000_000, 50);
    }
    @GetMapping("/data6")
    public Product getData6(){
        return new Product(7,"Nokia", "Android",1_000_000, 50);
    }
    @GetMapping("/data7")
    public Product getData7(){
        return new Product(8,"Asus","Android",1_500_000,100);
    }
    @GetMapping("/data8")
    public Product getData8(){
        return new Product(9,"Redmi", "Android", 6_000_000, 300);
    }
}
