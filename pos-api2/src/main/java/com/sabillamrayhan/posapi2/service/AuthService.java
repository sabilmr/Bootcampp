package com.sabillamrayhan.posapi2.service;

import com.sabillamrayhan.posapi2.model.AuthRequest;
import com.sabillamrayhan.posapi2.model.AuthResponse;
import com.sabillamrayhan.posapi2.model.ProfileResponse;
import com.sabillamrayhan.posapi2.model.RegisterRequest;
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
