package com.sabilla.pos.service;

import com.sabilla.pos.model.AuthRequest;
import com.sabilla.pos.model.AuthResponse;
import com.sabilla.pos.model.ProfileResponse;
import com.sabilla.pos.model.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

public interface AuthService {
    Optional<AuthResponse> authenticate(AuthRequest request);
    Optional<AuthResponse> register(RegisterRequest request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
    Optional<ProfileResponse> profile(HttpServletRequest request, HttpServletResponse response);
}
