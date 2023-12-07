package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.HandphoneEntity;
import com.bootcamp.belajarspringjpa.model.HandphoneDto;
import com.bootcamp.belajarspringjpa.repository.HandphoneRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HandphoneServiceImpl implements HandphoneService {
    private HandphoneRepo hanephoneRepo;

    public HandphoneServiceImpl(HandphoneRepo hanephoneRepo) {
        this.hanephoneRepo = hanephoneRepo;
    }

    @Override
    public List<HandphoneEntity> getAll() {
        return hanephoneRepo.findAll();
    }

    @Override
    public HandphoneEntity getById(Integer id) {
        return hanephoneRepo.findById(id).orElse(new HandphoneEntity());
    }

    @Override
    public HandphoneEntity save(HandphoneDto request) {
        HandphoneEntity result = new HandphoneEntity();
        result.setId(request.getId());
        result.setNameMerk(request.getNameMerk());
        result.setRam(request.getRam());
        result.setBatrai(request.getBatrai());
        result.setHarga(request.getHarga());
        result.setStorage(request.getStorage());
        result.setLayar(request.getLayar());
        result.setDimensi(request.getDimensi());
        result.setTahunRilis(request.getTahunRilis());
        result.setWarna(request.getWarna());

   try {
       hanephoneRepo.save(result);
       log.info("Save handphone to database successfully");
       return result;

   } catch (Exception e){
       log.error("Save handphone to database failed, error {}",e.getMessage());
       return null;
   }
    }
    @Override
    public HandphoneEntity delete(Integer id) {
        HandphoneEntity entity = hanephoneRepo.findById(id).orElse(new HandphoneEntity());
        if (entity == null) {
            log.info("handphone with id : {} not found", id);
            return null;
        }
            try {
                hanephoneRepo.delete(entity);
                log.info("Delete handphone from database successfully");
                return entity;

            } catch (Exception e) {
                log.error("Delete handphone from datacase failed, error {}", e.getMessage());
                return null;
            }
    }
    @Override
    public HandphoneEntity update(Integer id, HandphoneDto request) {
        HandphoneEntity entity = hanephoneRepo.findById(id).orElse(new HandphoneEntity());
        if ( entity == null){
            log.info("handphone with id : {} not found",id);
            return null;
        }

        entity.setId(request.getId());
        entity.setNameMerk(request.getNameMerk());
        entity.setRam(request.getRam());
        entity.setBatrai(request.getBatrai());
        entity.setHarga(request.getHarga());
        entity.setStorage(request.getStorage());
        entity.setLayar(request.getLayar());
        entity.setDimensi(request.getDimensi());
        entity.setTahunRilis(request.getTahunRilis());
        entity.setWarna(request.getWarna());

   try {
       hanephoneRepo.save(entity);
       log.info("save handphone to database successfully");
       return entity;

   } catch (Exception e){
       log.error("save handphone to database failed, error {}",e.getMessage());
       return null;
   }
    }
}
