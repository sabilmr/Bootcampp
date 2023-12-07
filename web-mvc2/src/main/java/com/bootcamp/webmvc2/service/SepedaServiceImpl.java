package com.bootcamp.webmvc2.service;

import com.bootcamp.webmvc2.entity.SepedaEntity;
import com.bootcamp.webmvc2.model.SepedaDto;
import com.bootcamp.webmvc2.repository.SepedaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SepedaServiceImpl implements SepedaService{
    private final SepedaRepo sepedaRepo;

    public SepedaServiceImpl(SepedaRepo sepedaRepo) {
        this.sepedaRepo = sepedaRepo;
    }

    @Override
    public List<SepedaEntity> getAll() {
        return sepedaRepo.findAll();
    }

    @Override
    public SepedaEntity getById(Integer id) {
        return sepedaRepo.findById(id).orElse(null);
    }

    @Override
    public SepedaEntity save(SepedaDto request) {
        SepedaEntity sepedaEntity = new SepedaEntity();

        BeanUtils.copyProperties(request,sepedaEntity);
    try {
        sepedaRepo.save(sepedaEntity);
        log.info("Save sepeda to database is successfully");
        return sepedaEntity;

    } catch (Exception e){
        log.error("Save sepeda to database is failed, error : {}",e.getMessage());
        return null;
    }
    }

    @Override
    public SepedaEntity delete(Integer id) {
        SepedaEntity entity = sepedaRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Sepeda with id : {} not found",id);
            return null;
        }
    try {
        sepedaRepo.delete(entity);
        log.info("Delete sepeda to database is successfully");
        return entity;

    } catch (Exception e){
        log.error("Delete sepeda to database is failed, error : {}",e.getMessage());
        return null;
    }
    }

    @Override
    public SepedaEntity update(Integer id, SepedaDto request) {
        SepedaEntity entity = sepedaRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Sepeda with id : {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
    try {
        sepedaRepo.save(entity);
        log.info("Save sepeda is successfully");
        return entity;
        
    } catch (Exception e){
        log.error("Save sepeda is failed, error : {}",e.getMessage());
        return null;
    }
    }
}
