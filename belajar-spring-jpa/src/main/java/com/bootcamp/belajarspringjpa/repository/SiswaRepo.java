package com.bootcamp.belajarspringjpa.repository;

import com.bootcamp.belajarspringjpa.entity.SiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepo extends JpaRepository<SiswaEntity,Integer> {
}
