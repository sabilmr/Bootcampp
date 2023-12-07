package com.sabilla.nortwinddapp.service.impl;

import com.sabilla.nortwinddapp.model.entity.CategoryEntity;
import com.sabilla.nortwinddapp.model.response.CategoryResponse;
import com.sabilla.nortwinddapp.repository.CategoryRepo;
import com.sabilla.nortwinddapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepo.findAll().stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getById(String id) {
        if (id == null){
            return null;
        }
        return categoryRepo.findById(id)
                .map(CategoryResponse::new)
                .orElse(null);
    }

    @Override
    public Optional<CategoryResponse> save(CategoryResponse response) {
        if (response == null){
            return Optional.empty();
        }

        CategoryEntity entity = new CategoryEntity(response);
        try {
            categoryRepo.save(entity);
            log.info("Save category success");
            return Optional.of(new CategoryResponse());
        }catch (Exception e){
            log.error("Save category failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryResponse> update(CategoryResponse response, String id) {
        CategoryEntity entity = categoryRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(response, entity);
        try {
            categoryRepo.save(entity);
            log.info("Update category success");
            return Optional.of(new CategoryResponse());
        }catch (Exception e){
            log.error("Update category failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryResponse> delete(String id) {
        CategoryEntity entity = categoryRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        try {
            categoryRepo.delete(entity);
            log.info("Delete category success");
            return Optional.of(new CategoryResponse());
        }catch (Exception e){
            log.error("Delete category failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
