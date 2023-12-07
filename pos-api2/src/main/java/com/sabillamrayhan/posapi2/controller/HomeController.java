package com.sabillamrayhan.posapi2.controller;

import com.sabillamrayhan.posapi2.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/")
public class HomeController {
    @GetMapping("test")
    public ResponseEntity<Response> getTest(){
        return ResponseEntity.ok().body(new Response(200,"Succes","Welcome to pos api"));
    }
}
