package com.bootcamp.belajarspringjpa.repository;

import com.bootcamp.belajarspringjpa.entity.HewanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HewanRepo extends JpaRepository<HewanEntity,Integer> {
}
