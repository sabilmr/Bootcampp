package com.bootcamp.belajarspringjpa1.repository;

import com.bootcamp.belajarspringjpa1.entity.LeptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeptopRepo extends JpaRepository<LeptopEntity, Integer> {
}
