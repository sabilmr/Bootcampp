package com.sabillamrayhan.posapi3.controller;

import com.sabillamrayhan.posapi3.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v3/auth")
public class HomeController {

    @GetMapping("/test")
    private ResponseEntity<Response> getTest(){
        return ResponseEntity.ok().body(new Response(200,"SUCCESS","Welcome to test"));
    }
}
