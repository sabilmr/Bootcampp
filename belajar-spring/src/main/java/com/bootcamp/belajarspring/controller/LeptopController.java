package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.Leptop;
import com.bootcamp.belajarspring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leptop")
public class LeptopController {
    @GetMapping("/kualitas")
    public Leptop getKualitas(){
        return new Leptop(20,"Apple MacBook Pro12",20_000_000,50);
    }

    @PostMapping
    public ResponseEntity<Object> mapPing(@RequestBody Leptop request){
        return ResponseEntity.ok().body("Data class yang bernama leptop otw meluncur ke postman");
    }
    @PostMapping("/data")
    public ResponseEntity<Object> postData(@RequestBody Leptop request){
        Response result = new Response(200,"SUCCES",request);
        return ResponseEntity.ok().body(result);
    }
    @PostMapping("/data1")
    public ResponseEntity<Object> postData1(@RequestBody Leptop request){
        Response result = new Response(200, "SUCCES", request);
        return ResponseEntity.ok().body(result);
    }
}
