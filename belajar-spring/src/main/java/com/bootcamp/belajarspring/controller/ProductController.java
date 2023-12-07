package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public Product get(){
        Product data1 = new Product();
        return data1;
    }
    @GetMapping("/data")
    public Product getData(){
        Product data1 = new Product(1,
                "leptop",
                "sangat bagus",
                1000000,
                10);
        return data1;
    }
    @GetMapping("/direct")
    public Product getDirect(){
        return new Product();
    }
    @GetMapping("/direct2")
    public Product getDirect2(){
        return new Product(2,
                "Kopi Robusta Lampung",
                "Wenak banget",
                75000,
                10);
    }
    @GetMapping("/hp")
    public Product getHp(){
        return new Product(3,
                "Oppo",
                "Android",
                4_000_000,
                50);
    }
    @GetMapping("/gelas")
    public Product getGelas(){
        return new Product(4,
                "Gelas",
                "Terbuat Dari Kaca",
                10_000,
                40);
    }
    @GetMapping("/buku")
    public Product getBuku(){
        return new Product(5,
                "Buku tulis",
                "Buat Menulis",
                15_000,
                30);
    }
    @GetMapping("/kopi")
    public Product getKopi(){
        return new Product(6,
                "Kopi Good Day",
                "Seperti Americano",
                10_000,
                12);
    }
    @PostMapping
    public ResponseEntity<Object> postData(@RequestBody Product request){
        return ResponseEntity
                .ok()
                .body("Data Berhasil Di Terima");
    }
    @PostMapping("/with-response")
    public ResponseEntity<Object>postWithResponse(@RequestBody Product request){
        Response result = new Response(200,"SUCCES",request);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @PostMapping("/manusia")
    public ResponseEntity<Object>postManusia(@RequestBody Product request){
        Response result=new Response(200,"SUCCESS",request);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @PostMapping("/data8")
    public ResponseEntity<Object>postData8(@RequestBody Pelajaran request){
        Response result = new Response(200,"SUCCESS",request);
        return ResponseEntity
                .ok()
                .body(result);
    }

}
