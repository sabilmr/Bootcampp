package com.sabilla.pos.controller;

import com.sabilla.pos.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class HomeController {
    @GetMapping("test")
    public ResponseEntity<Response> getTest(){
        return ResponseEntity.ok().body(new Response(200,"Succes","Welcome to pos api"));
    }
}
