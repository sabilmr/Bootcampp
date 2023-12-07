package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.MobilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilRepo extends JpaRepository<MobilEntity,Integer> {
}
