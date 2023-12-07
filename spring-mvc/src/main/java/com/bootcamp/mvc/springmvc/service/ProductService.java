package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.ProductEntity;
import com.bootcamp.mvc.springmvc.model.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAll();
    ProductEntity getById(Integer id);
    ProductEntity save(ProductDto request);
    ProductEntity delete (Integer id);
    ProductEntity update (Integer id, ProductDto request);
}
