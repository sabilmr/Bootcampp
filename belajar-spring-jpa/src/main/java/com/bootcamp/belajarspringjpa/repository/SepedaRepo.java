package com.bootcamp.belajarspringjpa.repository;

import com.bootcamp.belajarspringjpa.entity.SepedaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SepedaRepo extends JpaRepository<SepedaEntity, Integer> {
}
