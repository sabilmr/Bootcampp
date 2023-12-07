package com.sabilla.nortwinddapp.repository;

import com.sabilla.nortwinddapp.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, String> {
}
