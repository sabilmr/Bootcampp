package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.CameraEntity;
import com.bootcamp.mvc.springmvc.model.CameraDto;
import com.bootcamp.mvc.springmvc.repository.CameraRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CameraServiceImpl implements CameraService{
    private final CameraRepo cameraRepo;

    public CameraServiceImpl(CameraRepo cameraRepo) {
        this.cameraRepo = cameraRepo;
    }

    @Override
    public List<CameraEntity> getAll() {
        return cameraRepo.findAll();
    }

    @Override
    public CameraEntity getById(Integer id) {
        return cameraRepo.findById(id).orElse(new CameraEntity());
    }

    @Override
    public CameraEntity save(CameraDto request) {
        CameraEntity result = new CameraEntity();

        BeanUtils.copyProperties(request,result);
    try {
        cameraRepo.save(result);
        log.info("Save camera to database is successfully");
        return result;

    } catch (Exception ex){
        log.error("Save camera to database is failed,error : {}",ex.getMessage());
        return null;
    }
    }

    @Override
    public CameraEntity delete(Integer id) {
        CameraEntity entity = cameraRepo.findById(id).orElse(new CameraEntity());
        if (entity == null){
            log.info("Camera with id : {} not found",id);
            return null;
        }
        try {
            cameraRepo.delete(entity);
            log.info("Delete camera from database is successfully");
            return entity;

        } catch (Exception ex){
            log.error("Delete camera from database is failed,error : {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public CameraEntity update(Integer id, CameraDto request) {
        CameraEntity entity = cameraRepo.findById(id).orElse(new CameraEntity());
        if(entity == null) {
            log.info("Camera with id : {} not found", id);
            return null;

        }
        BeanUtils.copyProperties(request,entity);
        try {
            cameraRepo.save(entity);
            log.info("Save camera to database is successfully");
            return entity;

        } catch (Exception ex){
            log.error("Save camera to database is failed,error : {}",ex.getMessage());
            return null;
        }
        }

    }

