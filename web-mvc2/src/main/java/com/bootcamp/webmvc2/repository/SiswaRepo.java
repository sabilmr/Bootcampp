package com.bootcamp.webmvc2.repository;

import com.bootcamp.webmvc2.entity.SiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepo extends JpaRepository<SiswaEntity,Integer> {
}
