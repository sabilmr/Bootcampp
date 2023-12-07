package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.Minuman;
import com.bootcamp.belajarspring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/minuman")
public class MinumanController {

    @PostMapping
    public ResponseEntity<Object> postData(@RequestBody Minuman request){
        return ResponseEntity.ok().body("Data Yang Akan Di Kirim Ke Postman");
    }

     @PostMapping("rasa")
    public ResponseEntity<Object> postRasa(@RequestBody Minuman request){
         Response result = new Response(200,"SUCCES",request);
         return ResponseEntity.ok().body(result);
     }
}
