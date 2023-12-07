package com.bootcsmp.securitydemo.repository;

import com.bootcsmp.securitydemo.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<CartEntity, String> {
}
