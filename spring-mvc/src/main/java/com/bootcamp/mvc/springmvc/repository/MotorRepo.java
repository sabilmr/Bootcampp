package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.MotorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorRepo extends JpaRepository<MotorEntity,Integer> {
}
