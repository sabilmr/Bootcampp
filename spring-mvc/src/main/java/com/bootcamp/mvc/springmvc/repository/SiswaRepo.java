package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.SiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepo extends JpaRepository<SiswaEntity,Integer> {
}
