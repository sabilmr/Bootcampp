package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.Orang;
import com.bootcamp.belajarspring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orang")
public class OrangController {

    @GetMapping("/manusia")
    public Orang getManusia(){
        return new Orang(15,
                "Sabilla Muhammad Rayhan",
                "Laki-laki",
                "Dusun Jedung-Desa Sebani");
    }
    @PostMapping("/manusia1")
    public ResponseEntity<Object> getManusia1(@RequestBody Orang request){
        Response result = new Response(200,"SUCCES",request);
        return ResponseEntity
                .ok()
                .body(result);
    }

}
