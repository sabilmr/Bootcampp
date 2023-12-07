package com.sabilla.nortwinddapp.service;

import com.sabilla.nortwinddapp.model.response.CategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryResponse> getAll();
    CategoryResponse getById(String id);
    Optional<CategoryResponse> save(CategoryResponse response);
    Optional<CategoryResponse> update(CategoryResponse response, String id);
    Optional<CategoryResponse> delete(String id);
}
