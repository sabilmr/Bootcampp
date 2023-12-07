package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.GuruEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuruRepo extends JpaRepository<GuruEntity, Integer> {
}
