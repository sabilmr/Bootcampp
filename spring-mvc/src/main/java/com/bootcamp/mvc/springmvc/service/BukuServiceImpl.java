package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.BukuEntity;
import com.bootcamp.mvc.springmvc.model.BukuDto;
import com.bootcamp.mvc.springmvc.repository.BukuRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BukuServiceImpl implements BukuService{
    private final BukuRepo bukuRepo;

    public BukuServiceImpl(BukuRepo bukuRepo) {
        this.bukuRepo = bukuRepo;
    }

    @Override
    public List<BukuEntity> getAll() {
        return bukuRepo.findAll();
    }

    @Override
    public BukuEntity getById(Integer id) {
        return bukuRepo.findById(id).orElse(new BukuEntity());
    }

    @Override
    public BukuEntity save(BukuDto request) {
        BukuEntity result = new BukuEntity();

        BeanUtils.copyProperties(request,result);
   try {
       bukuRepo.save(result);
       log.info("Save buku to database is successfully");
       return result;

   }catch (Exception ex){
       log.error("Save buku to database is failed,error : {}",ex.getMessage());
       return null;
   }
    }

    @Override
    public BukuEntity delete(Integer id) {
        BukuEntity entity = bukuRepo.findById(id).orElse(new BukuEntity());
        if(entity == null){
            log.info("Buku with id : {} not found",id);
            return null;
        }
        try {
            bukuRepo.delete(entity);
            log.info("Delete buku from database is successfully");
            return entity;

        }catch (Exception ex){
            log.error("Detele buku to database is failed,error :{}",ex.getMessage());
            return null;
        }
    }

    @Override
    public BukuEntity update(Integer id, BukuDto request) {
        BukuEntity entity = bukuRepo.findById(id).orElse(new BukuEntity());
        if(entity == null){
            log.info("Buku with id : {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
    try {
        bukuRepo.save(entity);
        log.info("Save buku to database is successfully");
        return entity;

    }catch (Exception ex){
        log.error("Save buku to database is failed,error : {}",ex.getMessage());
        return null;
    }
    }
}
