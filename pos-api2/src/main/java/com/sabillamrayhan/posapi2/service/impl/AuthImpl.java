package com.sabillamrayhan.posapi2.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabillamrayhan.posapi2.config.CommonConstant;
import com.sabillamrayhan.posapi2.config.JwtService;
import com.sabillamrayhan.posapi2.entity.RoleEntity;
import com.sabillamrayhan.posapi2.entity.TokenEntity;
import com.sabillamrayhan.posapi2.entity.UserEntity;
import com.sabillamrayhan.posapi2.model.AuthRequest;
import com.sabillamrayhan.posapi2.model.AuthResponse;
import com.sabillamrayhan.posapi2.model.ProfileResponse;
import com.sabillamrayhan.posapi2.model.RegisterRequest;
import com.sabillamrayhan.posapi2.repository.RoleRepo;
import com.sabillamrayhan.posapi2.repository.TokenRepo;
import com.sabillamrayhan.posapi2.repository.UserRepo;
import com.sabillamrayhan.posapi2.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthImpl implements AuthService {
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final TokenRepo tokenRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public Optional<AuthResponse> authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserEntity user = userRepo.findByEmail(request.getEmail()).orElse(null);
        if (user == null){
            log.info("User not found");
            return Optional.empty();
        }
        return getResponse(user, false);
    }

    @Override
    public Optional<AuthResponse> register(RegisterRequest request) {
        if (request ==null){
            return Optional.empty();
        }
        if (userRepo.findByEmail(request.getEmail()).isPresent()){
            log.info("Email already in used");
            return Optional.empty();
        }
        UserEntity user = new UserEntity();

        BeanUtils.copyProperties(request, user);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        RoleEntity role = getRole(request.getRole());
        if (role != null){
            user.setRoles(List.of(role));
        }
        try {
            userRepo.save(user);
            log.info("Create user success");
            return getResponse(user, true);
        }catch (Exception e){
            log.error("Create user failed. error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    private RoleEntity getRole(String roleName) {
        RoleEntity role = roleRepo.findByName(roleName).orElse(null);
        if (role != null){
            return role;
        }
        role = roleRepo.findByName(CommonConstant.DEFAULT_ROLE).orElse(null);
        return role;
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;

        if (authHeader == null || !authHeader.startsWith(CommonConstant.BEARER_VALUE)){
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);

        if (userEmail != null){
            UserEntity user = userRepo.findByEmail(userEmail).orElseThrow(()-> new UsernameNotFoundException("User not found"));

            if (jwtService.isTokenValid(refreshToken, user)) {
                Optional<AuthResponse> authResponse = this.getResponse(user, false);

                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    @Override
    public Optional<ProfileResponse> profile(HttpServletRequest request, HttpServletResponse response) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;

        if (authHeader == null || !authHeader.startsWith(CommonConstant.BEARER_VALUE)){
            return Optional.empty();
        }

        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);

        if (userEmail == null){
            return Optional.empty();
        }

        UserEntity user = userRepo.findByEmail(userEmail).orElse(null);
        if (user == null){
            return Optional.empty();
        }

        ProfileResponse result = new ProfileResponse();
        BeanUtils.copyProperties(user, result);

        List<String> roles = user.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
        result.setRoles(roles);

        return Optional.of(result);
    }

    private Optional<AuthResponse> getResponse(UserEntity user, boolean isRegister) {
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        this.saveUserToken(user.getId(), jwtToken);

        if (!isRegister)
            this.revokeAllUserTokens(user);

        var result = new AuthResponse(jwtToken, refreshToken);
        return Optional.of(result);
    }

    private void revokeAllUserTokens(UserEntity user) {
        var validUserTokens = tokenRepo.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;

        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepo.saveAll(validUserTokens);
    }

    private void saveUserToken(Long userId, String jwtToken){
        var token = new TokenEntity();
        token.setUserId(userId);
        token.setToken(jwtToken);
        token.setTokenType(CommonConstant.BEARER_TYPE);
        token.setExpired(false);
        token.setRevoked(false);
        try {
            tokenRepo.save(token);
            log.info("Save token success");
        }catch (Exception e){
            log.error("Save token failed, error : {}",e.getMessage());
        }

    }
}
