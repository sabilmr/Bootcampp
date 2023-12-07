package com.bootcamp.belajarspringjpa.repository;

import com.bootcamp.belajarspringjpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository <ProductEntity, Integer> {
}
