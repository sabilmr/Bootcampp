package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.HandphoneEntity;
import com.bootcamp.mvc.springmvc.model.HandphoneDto;
import com.bootcamp.mvc.springmvc.model.ProductDto;
import com.bootcamp.mvc.springmvc.repository.HandphoneRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HandphoneServiceImpl implements HandphoneService{
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
        log.info("Save handphone to database is successfully");
        return result;

    } catch (Exception ex){
        log.error("Save handphone to database is failed, error : {}",ex.getMessage());
        return null;
    }
    }
    @Override
    public HandphoneEntity delete(Integer id) {
        HandphoneEntity entity = handphoneRepo.findById(id).orElse(new HandphoneEntity());
        if (entity == null) {
            log.warn("Handphone with id :{} not found", id);
            return null;
        }
        try {
            handphoneRepo.delete(entity);
            log.info("Delete handphone to database is successfully");
            return entity;

        }catch (Exception ex){
            log.error("Delete handphone to database is failed, error : {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public HandphoneEntity update(Integer id,HandphoneDto request) {
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

        }catch (Exception ex){
            log.error("Save handphone to database failed,error : {}",ex.getMessage());
            return null;
        }
    }
}
