package com.bootcamp.webmvc2.repository;

import com.bootcamp.webmvc2.entity.MotorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorRepo extends JpaRepository<MotorEntity,Integer> {
}
