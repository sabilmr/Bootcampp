package com.bootcamp.belajarspringjpa.repository;

import com.bootcamp.belajarspringjpa.entity.MinyakwangiEntity;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinyakwangiRepo extends JpaRepository<MinyakwangiEntity,Integer> {
}
