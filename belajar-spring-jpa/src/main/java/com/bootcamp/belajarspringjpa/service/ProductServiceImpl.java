package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.ProductEntity;
import com.bootcamp.belajarspringjpa.model.ProductDto;
import com.bootcamp.belajarspringjpa.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    private ProductRepo productRepo;

   public ProductServiceImpl(ProductRepo productRepo){
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
    public ProductEntity save(ProductDto requaet) {
       ProductEntity result = new ProductEntity();
       result.setId(requaet.getId());
       result.setName(requaet.getName());
       result.setDescription(requaet.getDescription());
       result.setPrice(requaet.getPrice());
       result.setQuantity(requaet.getQuantity());

    try {
        productRepo.save(result);
        log.info("Save product to database successfully");
        return result;

    } catch (Exception e){
        log.error("Save product to database failed,error {}",e.getMessage());
        return null;
    }
   }

    @Override
    //cari data product base on id
    public ProductEntity delete(int id) {
        ProductEntity entity = productRepo.findById(id).orElse(new ProductEntity());
       if (entity == null) {
           log.info("product with id : {} not found", id);
           return null;
       }

       try {
           //proses delete ke database
           productRepo.delete(entity);
           log.info("Delete product from database successfully");
           return entity;

           //jika ada error
       } catch (Exception e){
           log.error("Delete product from database failed,error {}",e.getMessage());
           return null;
       }
   }

    @Override
    public ProductEntity update(int id, ProductDto request) {
        ProductEntity entity = productRepo.findById(id).orElse(new ProductEntity());
        if (entity == null) {
            log.info("product with id : {} not found ",id);
            return null;
        }
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setPrice(request.getPrice());
        entity.setQuantity(request.getQuantity());

    try {
        productRepo.save(entity);
        log.info("Save product from database successfully");
        return entity;

    }catch (Exception e){
        log.error("save product from database failed, error {}",e.getMessage());
        return null;
    }
    }
}
