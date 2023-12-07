package com.bootcamp.webmvc2.service;

import com.bootcamp.webmvc2.entity.MotorEntity;
import com.bootcamp.webmvc2.model.MotorDto;
import com.bootcamp.webmvc2.repository.MotorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MotorServiceImpl implements MotorService {
    private final MotorRepo motorRepo;

    public MotorServiceImpl(MotorRepo motorRepo) {
        this.motorRepo = motorRepo;
    }

    @Override
    public List<MotorEntity> getAll() {
        return motorRepo.findAll();
    }

    @Override
    public MotorEntity getById(Integer id) {
        return motorRepo.findById(id).orElse(new MotorEntity());
    }

    @Override
    public MotorEntity save(MotorDto request) {
        MotorEntity result = new MotorEntity();

        BeanUtils.copyProperties(request,result);
    try {
        motorRepo.save(result);
        log.info("Save motor to database is successfully");
        return result;

    } catch (Exception e){
        log.error("Save motor to database is failed,error : {}",e.getMessage());
        return null;
    }
    }

    @Override
    public MotorEntity delete(Integer id) {
        MotorEntity entity = motorRepo.findById(id).orElse(new MotorEntity());
        if (entity == null){
            log.warn("Motor with id : {} not found",id);
            return null;
        }
   try {
       motorRepo.delete(entity);
       log.info("Delete motor to database is successfully");
       return entity;

   } catch (Exception e){
       log.error("Delete motor to database is failed,error : {}",e.getMessage());
       return null;
   }
    }

    @Override
    public MotorEntity update(Integer id, MotorDto request) {
        MotorEntity entity = motorRepo.findById(id).orElse(new MotorEntity());
        if (entity == null){
            log.warn("Motor with id : {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
    try {
        motorRepo.save(entity);
        log.info("Save motor to database is successfully");
        return entity;

    } catch (Exception e){
        log.error("Save motor to database is failed,error : {}",e.getMessage());
        return null;
    }
    }
}
