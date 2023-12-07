package com.bootcsmp.securitydemo.controller;

import com.bootcsmp.securitydemo.config.IAuthenticationFacade;
import com.bootcsmp.securitydemo.config.JwtUtils;
import com.bootcsmp.securitydemo.dto.AuthRequest;
import com.bootcsmp.securitydemo.dto.Response;
import com.bootcsmp.securitydemo.dto.UserResponse;
import com.bootcsmp.securitydemo.entity.UserEntity;
import com.bootcsmp.securitydemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserService userDetailsService;
    private final JwtUtils jwtUtils;
    private final IAuthenticationFacade authenticationFacade;

    @PostMapping("/authenticate")
    public ResponseEntity<Response> authenticate(@RequestBody AuthRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
        final UserDetails user = userDetailsService.loadUserByUsername(request.getEmail());

        if (user != null){
            String token = jwtUtils.generateToken(user);
            return ResponseEntity.ok(new Response(200,"Succes",token));

        } else {
            return ResponseEntity.status(400).body(new Response(400,"Something has error ocurred",null));

        }
    }
    @GetMapping("/username")
    public ResponseEntity<Response> getUsername(){
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        Optional<UserEntity> userEntity = userDetailsService.getByEmail(username);

        if (userEntity.isPresent()){
            UserResponse result = new UserResponse(userEntity.get());
            return ResponseEntity.ok().body(new Response(200,"Succes",result));
        } else {
            return ResponseEntity.status(500).body(new Response(500,"FAILED","User not found"));
        }
    }
}
