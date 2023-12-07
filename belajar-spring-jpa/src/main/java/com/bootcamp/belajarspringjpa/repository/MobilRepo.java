package com.bootcamp.belajarspringjpa.repository;

import com.bootcamp.belajarspringjpa.entity.MobilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilRepo extends JpaRepository<MobilEntity,Integer> {
}
