package com.bootcamp.belajarspringjpa1.controller;

import com.bootcamp.belajarspringjpa1.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("ping1")
    public ResponseEntity<Response> ping1(){
        Response result = new Response(200,"Succes","ping1");
        return ResponseEntity.ok().body(result);
    }
}
