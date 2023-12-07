package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.ProductEntity;
import com.bootcamp.belajarspringjpa.model.ProductDto;

import java.util.List;

public interface ProductService {
   List<ProductEntity> getAll();
   ProductEntity getById(Integer id);
   ProductEntity save(ProductDto requaet);
   ProductEntity delete(int id);
   ProductEntity update(int id, ProductDto request);
}
