package com.bootcamp.springsecurity3.service;

import com.bootcamp.springsecurity3.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserEntity> getAll();
}
