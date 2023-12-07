package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.Makanan;
import com.bootcamp.belajarspring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Makanan")
public class MakananController {

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody Makanan request){
        return ResponseEntity.ok().body("Data Yang Ada Di Dalam Class Akan Di Kirim Ke Postman");
    }

    @PostMapping("/data")
    public ResponseEntity<Object> postData(@RequestBody Makanan request){
        Response result = new Response(200,"SUCCES",request);
        return ResponseEntity.ok().body(result);
    }

}
