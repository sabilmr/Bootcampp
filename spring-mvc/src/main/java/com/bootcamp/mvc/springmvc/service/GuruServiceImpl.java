package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.GuruEntity;
import com.bootcamp.mvc.springmvc.model.GuruDto;
import com.bootcamp.mvc.springmvc.repository.GuruRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GuruServiceImpl implements GuruService{
    private final GuruRepo guruRepo;

    public GuruServiceImpl(GuruRepo guruRepo) {
        this.guruRepo = guruRepo;
    }

    @Override
    public List<GuruEntity> getAll() {
        return guruRepo.findAll();
    }

    @Override
    public GuruEntity getById(Integer id) {
        return guruRepo.findById(id).orElse(new GuruEntity());
    }

    @Override
    public GuruEntity save(GuruDto request) {
        GuruEntity guruEntity = new GuruEntity();

        BeanUtils.copyProperties(request,guruEntity);
    try {
        guruRepo.save(guruEntity);
        log.info("Save guru to database is successfully");
        return guruEntity;

    } catch (Exception ex){
        log.error("Save guru to database is failed, error : {}",ex.getMessage());
        return null;
    }
    }

    @Override
    public GuruEntity delete(Integer id) {
        GuruEntity entity = guruRepo.findById(id).orElse(new GuruEntity());
        if(entity == null){
            log.warn("Guru with id : {} not found",id);
            return null;
        }
    try {
        guruRepo.delete(entity);
        log.info("Delete guru to database is successfully");
        return entity;

    } catch (Exception ex){
        log.error("Delete guru to database is failed,error : {}",ex.getMessage());
        return null;
    }
    }

    @Override
    public GuruEntity update(Integer id, GuruDto request) {
        GuruEntity entity = guruRepo.findById(id).orElse(new GuruEntity());
        if(entity == null){
            log.warn("Guru with id : {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
    try {
        guruRepo.save(entity);
        log.info("Save guru to database is successfully");
        return entity;

    } catch (Exception ex){
        log.error("Save guru to database is failed,error : {}",ex.getMessage());
        return null;
    }
    }
}
