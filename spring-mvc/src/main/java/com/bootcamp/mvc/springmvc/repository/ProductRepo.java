package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
}
