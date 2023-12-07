package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.BukuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepo extends JpaRepository<BukuEntity,Integer> {
}
