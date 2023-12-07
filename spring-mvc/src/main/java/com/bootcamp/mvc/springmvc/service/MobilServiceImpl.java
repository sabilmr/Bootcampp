package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.MobilEntity;
import com.bootcamp.mvc.springmvc.model.MobilDto;
import com.bootcamp.mvc.springmvc.repository.MobilRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MobilServiceImpl implements MobilService{
    private final MobilRepo mobilRepo;

    public MobilServiceImpl(MobilRepo mobilRepo) {
        this.mobilRepo = mobilRepo;
    }

    @Override
    public List<MobilEntity> getAll() {
        return mobilRepo.findAll();
    }

    @Override
    public MobilEntity getById(Integer id) {
        return mobilRepo.findById(id).orElse(new MobilEntity());
    }

    @Override
    public MobilEntity save(MobilDto request) {
        MobilEntity result = new MobilEntity();

        BeanUtils.copyProperties(request,result);
    try {
        mobilRepo.save(result);
        log.info("Save mobil to database is successfully");
        return result;

    }catch (Exception ex){
        log.error("Save mobil to database is failed,error : {}",ex.getMessage());
        return null;
    }
    }

    @Override
    public MobilEntity delete(Integer id) {
        MobilEntity entity = mobilRepo.findById(id).orElse(new MobilEntity());
        if (entity == null){
            log.info("Mobil with id : {} not found",id);
            return null;
        }
        try {
            mobilRepo.delete(entity);
            log.info("Delete mobil to database is successfully");
            return entity;

        } catch (Exception ex){
            log.error("Delete mobil to database is failed,error : {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public MobilEntity update(Integer id, MobilDto request) {
        MobilEntity entity = mobilRepo.findById(id).orElse(new MobilEntity());
        if (entity == null){
            log.info("Mobil with id : {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
    try {
        mobilRepo.save(entity);
        log.info("Save mobil to database is successfully");
        return entity;

    } catch (Exception ex){
        log.error("Save mobil to database is failed, error : {}",ex.getMessage());
        return null;
    }
    }
}
