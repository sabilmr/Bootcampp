package com.sabillamrayhan.posapi3.service.impl;

import com.sabillamrayhan.posapi3.entity.ProductEntity;
import com.sabillamrayhan.posapi3.model.ProductModel;
import com.sabillamrayhan.posapi3.repository.CategoryRepo;
import com.sabillamrayhan.posapi3.repository.ProductRepo;
import com.sabillamrayhan.posapi3.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<ProductEntity> getById(Long id) {
        if (id == 0L)
            return Optional.empty();

        return productRepo.findById(id);
    }

    @Override
    public Optional<ProductEntity> getByCode(String code) {
        if (code == null || code.isEmpty())
            return Optional.empty();

        return productRepo.findByCode(code);
    }

    @Override
    public Optional<ProductEntity> save(ProductModel request) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(request, entity);
        try {
            productRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception sabil){
            log.error("Save product failed, error: {}",sabil.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductEntity> update(ProductModel request, Long id) {
        if (id == 0L)
            return Optional.empty();

        ProductEntity entity = productRepo.findById(id).orElse(null);
        if (entity == null)
            return Optional.empty();
        BeanUtils.copyProperties(request, entity);
        try {
            productRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception sabil){
            log.error("Update product failed, error: {}",sabil.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductEntity> delete(Long id) {
        if (id == 0L)
            return Optional.empty();

        ProductEntity entity = productRepo.findById(id).orElse(null);
        if (entity == null)
            return Optional.empty();
        try {
            productRepo.delete(entity);
            return Optional.of(entity);
        }catch (Exception sabil){
            log.error("Delete product failed, error: {}",sabil.getMessage());
            return Optional.empty();
        }
    }
}
