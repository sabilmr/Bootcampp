package com.sabillamrayhan.posapi2.service;

import com.sabillamrayhan.posapi2.entity.ProductEntity;
import com.sabillamrayhan.posapi2.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> getAll();
    Optional<ProductEntity> getById(Long id);
    Optional<ProductEntity> getByCode(String code);
    Optional<ProductEntity> save(ProductModel request);
    Optional<ProductEntity> update(ProductModel request, Long id);
    Optional<ProductEntity> delete(Long id);
}
