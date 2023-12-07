package com.bootcamp.webmvc2.service;

import com.bootcamp.webmvc2.entity.HandphoneEntity;
import com.bootcamp.webmvc2.model.HandphoneDto;
import com.bootcamp.webmvc2.repository.HandphoneRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HandphoneServiceImpl implements HandphoneService {
    private final HandphoneRepo handphoneRepo;

    public HandphoneServiceImpl(HandphoneRepo handphoneRepo) {
        this.handphoneRepo = handphoneRepo;
    }

    @Override
    public List<HandphoneEntity> getAll() {
        return handphoneRepo.findAll();
    }

    @Override
    public HandphoneEntity getById(Integer id) {
        return handphoneRepo.findById(id).orElse(new HandphoneEntity());
    }

    @Override
    public HandphoneEntity save(HandphoneDto request) {
        HandphoneEntity result = new HandphoneEntity();

        BeanUtils.copyProperties(request,result);
   try {
       handphoneRepo.save(result);
       log.info("Save handphone to database is successfully");
       return result;

   } catch (Exception e){
       log.error("Save handphone to database is failed, erorr : {}",e.getMessage());
       return null;
   }
    }

    @Override
    public HandphoneEntity delete(Integer id) {
        HandphoneEntity entity = handphoneRepo.findById(id).orElse(new HandphoneEntity());
        if(entity == null){
            log.warn("Handphone with id : {} not found",id);
            return null;
        }
    try {
        handphoneRepo.delete(entity);
        log.info("Delete handphone to database is successfully");
        return entity;

    }catch (Exception e){
        log.error("Delete handphone to database is failed, error : {}",e.getMessage());
        return null;
    }
    }

    @Override
    public HandphoneEntity update(Integer id, HandphoneDto request) {
        HandphoneEntity entity = handphoneRepo.findById(id).orElse(new HandphoneEntity());
        if (entity == null){
            log.warn("Handphone with id : {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
    try {
        handphoneRepo.save(entity);
        log.info("Save handphone to database is successfully");
        return entity;

    }catch (Exception e){
        log.error("Save handphone to database is failed, error : {}",e.getMessage());
        return null;
    }
    }
}
