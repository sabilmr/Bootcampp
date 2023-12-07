package com.sabillamrayhan.posapi3.controller;

import com.sabillamrayhan.posapi3.model.*;
import com.sabillamrayhan.posapi3.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/authenticate")
    private ResponseEntity<Response> authenticate(@RequestBody AuthRequest request){
        Optional<AuthResponse> result = authService.authenticate(request);
        if (result.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",result));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"FAILED","Data not found"));
    }

    @PostMapping("/register")
    private ResponseEntity<Response> register(@RequestBody RegisterRequest request){
        Optional<AuthResponse> result = authService.register(request);
        if (result.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",result));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Register is failed"));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException{
        authService.refreshToken(request, response);
    }

    @GetMapping("/profile")
    private ResponseEntity<Response> profile(HttpServletRequest request, HttpServletResponse response){
        Optional<ProfileResponse> result = authService.profile(request, response);
        if (result.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",result));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Profile is failed"));
    }
}
