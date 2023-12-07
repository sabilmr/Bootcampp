package com.bootcsmp.securitydemo.repository;

import com.bootcsmp.securitydemo.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity,String> {
    Optional<RoleEntity> findByName(String name);
}
