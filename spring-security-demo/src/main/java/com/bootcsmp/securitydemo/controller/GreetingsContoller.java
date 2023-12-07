package com.bootcsmp.securitydemo.controller;

import com.bootcsmp.securitydemo.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greeting")
public class GreetingsContoller {

    @GetMapping("/say-hello")
    public ResponseEntity<Response> sayHello(){
        return ResponseEntity.ok().body(new Response(200,"Success","hello welcome to say hello"));
    }
    @GetMapping("/say-good-bay")
    public ResponseEntity<Response> sayGoodBay(){
        return ResponseEntity.ok().body(new Response(200,"Success","Hello,welcome say good bay"));
    }
}
