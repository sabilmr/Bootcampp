package com.sabillamrayhan.posapi2.repository;

import com.sabillamrayhan.posapi2.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String roleName);
}
