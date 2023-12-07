package com.sabilla.pos.controller;

import com.sabilla.pos.model.*;
import com.sabilla.pos.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<Response> authenticate(@RequestBody AuthRequest request){
        Optional<AuthResponse> result = authService.authenticate(request);
        if(result.isPresent()) {
            return ResponseEntity.ok().body(
                    new Response(200, "SUCCESS", result)
            );
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new Response(400,"FAILED","User Not found")
                );
    }
    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody RegisterRequest request){
        Optional<AuthResponse> result = authService.register(request);

        if (result.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",result));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"Failed","Register is failed"));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException{
        authService.refreshToken(request, response);
    }

    @GetMapping("/profile")
    public ResponseEntity<Response> getProfile(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Optional<ProfileResponse> result = authService.profile(request, response);
        if (result.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"success",result));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(500,"Failed","User not found"));
    }
}
