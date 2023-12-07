package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.LeptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeptopRepo extends JpaRepository<LeptopEntity,Integer> {
}
