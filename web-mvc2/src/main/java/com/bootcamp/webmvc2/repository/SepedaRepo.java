package com.bootcamp.webmvc2.repository;

import com.bootcamp.webmvc2.entity.SepedaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SepedaRepo extends JpaRepository<SepedaEntity,Integer> {
}
