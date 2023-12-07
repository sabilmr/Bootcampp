package com.bootcamp.belajarspringjpa.repository;

import com.bootcamp.belajarspringjpa.entity.HandphoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandphoneRepo extends JpaRepository <HandphoneEntity, Integer> {
}
