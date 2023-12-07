package com.bootcsmp.securitydemo.service;

import com.bootcsmp.securitydemo.dto.CartDto;
import com.bootcsmp.securitydemo.entity.CartEntity;
import com.bootcsmp.securitydemo.entity.CartItemEntity;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<CartEntity> getAll();
    Optional<CartEntity> getById(String id);
    Optional<CartEntity> save(CartDto request);
    Optional<CartEntity> simpleSave(CartDto request);
}
