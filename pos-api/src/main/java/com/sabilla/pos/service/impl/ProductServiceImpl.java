package com.sabilla.pos.service.impl;

import com.sabilla.pos.entity.ProductEntity;
import com.sabilla.pos.model.ProductRequest;
import com.sabilla.pos.repository.ProductRepo;
import com.sabilla.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
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
    public Optional<ProductEntity> save(ProductRequest request) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(request, entity);
        try {
            productRepo.save(entity);
            return Optional.of(entity);
        } catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductEntity> update(ProductRequest request, Long id) {
        if (id == 0L)
            return Optional.empty();

        ProductEntity entity = productRepo.findById(id).orElse(null);
        if (entity == null)
            return Optional.empty();

        BeanUtils.copyProperties(request, entity);
        try {
            productRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
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
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
