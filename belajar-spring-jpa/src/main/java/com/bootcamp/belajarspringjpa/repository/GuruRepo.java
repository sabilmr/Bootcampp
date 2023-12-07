package com.bootcamp.belajarspringjpa.repository;

import com.bootcamp.belajarspringjpa.entity.GuruEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuruRepo extends JpaRepository<GuruEntity,Integer> {
}
