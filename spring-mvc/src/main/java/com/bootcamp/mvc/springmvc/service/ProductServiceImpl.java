package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.ProductEntity;
import com.bootcamp.mvc.springmvc.model.ProductDto;
import com.bootcamp.mvc.springmvc.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }

    @Override
    public ProductEntity getById(Integer id) {
        return productRepo.findById(id).orElse(new ProductEntity());
    }

    @Override
    public ProductEntity save(ProductDto request) {

        //get data id dari daabase
        ProductEntity result = new ProductEntity();

        //copy property
        BeanUtils.copyProperties(request,result);
        try {
            this.productRepo.save(result);
            log.info("Save product to database is successfully");
            return result;
        }catch (Exception ex){
            log.error("Save product to database is failed, error : {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public ProductEntity delete(Integer id) {
        ProductEntity entity = this.productRepo.findById(id).orElse(new ProductEntity());
        if(entity == null){
            log.warn("Product with id :{} not found",id);
            return null;
        }
        try {
            productRepo.delete(entity);
            log.info("Delete from to datebase is successfully");
            return entity;

        }catch (Exception ex){
            log.error("Delete product to database is failed,error : {}",ex.getMessage());
            return null;
        }

    }

    @Override
    public ProductEntity update(Integer id, ProductDto request) {
        ProductEntity entity = productRepo.findById(id).orElse(new ProductEntity());

        //validasi data
        if(entity == null){
            log.warn("Product with id : {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
    try {
        this.productRepo.save(entity);
        log.info("Update product to database is successfully");
        return entity;

    }catch (Exception ex){
        log.error("Update product to database is failed, error:{}",ex.getMessage());
        return null;
    }
    }
}
