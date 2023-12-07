package com.sabilla.pos.service;

import com.sabilla.pos.entity.ProductEntity;
import com.sabilla.pos.model.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> getAll();
    Optional<ProductEntity> getById(Long id);
    Optional<ProductEntity> getByCode(String code);
    Optional<ProductEntity> save(ProductRequest request);
    Optional<ProductEntity> update(ProductRequest request, Long id);
    Optional<ProductEntity> delete(Long id);
}
