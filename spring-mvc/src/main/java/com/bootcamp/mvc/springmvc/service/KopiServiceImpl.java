package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.KopiEntity;
import com.bootcamp.mvc.springmvc.model.KopiDto;
import com.bootcamp.mvc.springmvc.repository.KopiRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KopiServiceImpl implements KopiService {
    private final KopiRepo kopiRepo;

    public KopiServiceImpl(KopiRepo kopiRepo) {
        this.kopiRepo = kopiRepo;
    }

    @Override
    public List<KopiEntity> getAll() {
        return kopiRepo.findAll();
    }

    @Override
    public KopiEntity getById(Integer id) {
        return kopiRepo.findById(id).orElse(new KopiEntity());
    }

    @Override
    public KopiEntity save(KopiDto request) {
        KopiEntity kopiEntity = new KopiEntity();

        BeanUtils.copyProperties(request,kopiEntity);
    try {
        kopiRepo.save(kopiEntity);
        log.info("Save kopi to database is successfully");
        return kopiEntity;

    }catch (Exception ex){
        log.error("Save kopi to database is failed, error : {}",ex.getMessage());
        return null;
    }
    }

    @Override
    public KopiEntity delete(Integer id) {
        KopiEntity entity = kopiRepo.findById(id).orElse(new KopiEntity());
        if (entity == null){
            log.info("Kopi with id : not found : {}",id);
            return null;
        }
    try {
        kopiRepo.delete(entity);
        log.info("Delete kopi from database is successfully");
        return entity;

    } catch (Exception ex){
        log.error("Delete kopi from database is failed,error : {}",ex.getMessage());
        return null;
    }
    }

    @Override
    public KopiEntity update(Integer id, KopiDto request) {
        KopiEntity entity = kopiRepo.findById(id).orElse(new KopiEntity());
        if (entity == null){
            log.info("Kopi with id : {} not found ",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
    try {
        kopiRepo.save(entity);
        log.info("Save kopi to database is successfully");
        return entity;

    } catch (Exception ex){
        log.error("Save kopi to database is failed,error : {}",ex.getMessage());
        return null;
    }
    }
}
