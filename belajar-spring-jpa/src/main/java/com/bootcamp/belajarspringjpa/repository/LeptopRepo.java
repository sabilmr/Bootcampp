package com.bootcamp.belajarspringjpa.repository;

import com.bootcamp.belajarspringjpa.entity.LeptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeptopRepo extends JpaRepository<LeptopEntity,Integer> {
}
