package com.sabillamrayhan.posapi3.service.impl;

import com.sabillamrayhan.posapi3.entity.CategoryEntity;
import com.sabillamrayhan.posapi3.model.CategoryModel;
import com.sabillamrayhan.posapi3.repository.CategoryRepo;
import com.sabillamrayhan.posapi3.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    @Override
    public List<CategoryEntity> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<CategoryEntity> getById(Long id) {
        if (id == 0L)
            return Optional.empty();

        return categoryRepo.findById(id);
    }

    @Override
    public Optional<CategoryEntity> getByCode(String code) {
        if (code == null || code.isEmpty())
           return Optional.empty();

        return categoryRepo.findByCode(code);
    }

    @Override
    public Optional<CategoryEntity> save(CategoryModel request) {
        CategoryEntity entity = new CategoryEntity();
        BeanUtils.copyProperties(request,entity);
        try {
            categoryRepo.save(entity);
            return Optional.of(entity);
        } catch (Exception sabil){
            log.error("Save category failed, error: {}",sabil.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryEntity> update(CategoryModel request, Long id) {
        if (id == 0L)
            return Optional.empty();

        CategoryEntity entity = categoryRepo.findById(id).orElse(null);
        if (entity == null)
            return Optional.empty();
        BeanUtils.copyProperties(request, entity);
        try {
            categoryRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception sabil){
            log.error("Save category failed, error: {}",sabil.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryEntity> delete(Long id) {
        if (id == 0L)
            return Optional.empty();

        CategoryEntity entity = categoryRepo.findById(id).orElse(null);
        if (entity == null)
            return Optional.empty();
        try {
            categoryRepo.delete(entity);
            return Optional.of(entity);
        }catch (Exception sabil){
            log.error("Delete category failed, error: {}",sabil.getMessage());
            return Optional.empty();
        }
    }
}
