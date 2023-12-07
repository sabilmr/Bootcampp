package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.HandphoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandphoneRepo extends JpaRepository<HandphoneEntity, Integer> {
}
