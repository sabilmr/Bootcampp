package com.sabillamrayhan.posapi3.service;

import com.sabillamrayhan.posapi3.entity.CategoryEntity;
import com.sabillamrayhan.posapi3.entity.ProductEntity;
import com.sabillamrayhan.posapi3.model.CategoryModel;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryEntity> getAll();
    Optional<CategoryEntity> getById(Long id);
    Optional<CategoryEntity> getByCode(String code);
    Optional<CategoryEntity> save(CategoryModel request);
    Optional<CategoryEntity> update(CategoryModel request, Long id);
    Optional<CategoryEntity> delete(Long id);
}
