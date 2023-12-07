package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.LeptopEntity;
import com.bootcamp.mvc.springmvc.model.LeptopDto;
import com.bootcamp.mvc.springmvc.repository.LeptopRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LeptopServiceImpl implements LeptopService{
    private final LeptopRepo leptopRepo;

    public LeptopServiceImpl(LeptopRepo leptopRepo) {
        this.leptopRepo = leptopRepo;
    }

    @Override
    public List<LeptopEntity> getAll() {
        return leptopRepo.findAll();
    }

    @Override
    public LeptopEntity getById(Integer id) {
        return leptopRepo.findById(id).orElse(new LeptopEntity());
    }

    @Override
    public LeptopEntity save(LeptopDto request) {
        LeptopEntity result = new LeptopEntity();

        BeanUtils.copyProperties(request,result);

    try {
        this.leptopRepo.save(result);
        log.info("Save leptop to database is successfully");
        return result;

    } catch (Exception ex){
        log.error("Save leptop to database is failed,error : {}",ex.getMessage());
        return null;
    }
    }

    @Override
    public LeptopEntity delete(Integer id) {
        LeptopEntity entity = leptopRepo.findById(id).orElse(null);
        if(entity == null){
            log.info("Leptop with id : {} not found",id);
            return null;
        }
        try {
            leptopRepo.delete(entity);
            log.info("Delete leptop from database is successfully");
            return entity;

        } catch (Exception ex){
            log.error("Delete leptop from database failed, error : {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public LeptopEntity update(Integer id, LeptopDto request) {
        LeptopEntity entity = leptopRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Leptop with id : {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
    try {
        leptopRepo.save(entity);
        log.info("Save leptop to database is successfully");
        return entity;

    } catch (Exception ex){
        log.error("Save leptop to database failed, error : {}",ex.getMessage());
        return null;
    }
    }
}
