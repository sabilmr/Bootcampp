package com.bootcamp.webmvc2.repository;

import com.bootcamp.webmvc2.entity.HandphoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandphoneRepo extends JpaRepository<HandphoneEntity,Integer> {
}
