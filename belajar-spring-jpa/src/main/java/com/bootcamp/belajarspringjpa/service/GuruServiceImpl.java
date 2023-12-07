package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.GuruEntity;
import com.bootcamp.belajarspringjpa.model.GuruDto;
import com.bootcamp.belajarspringjpa.repository.GuruRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GuruServiceImpl implements GuruService{
    private GuruRepo guruRepo;

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
        GuruEntity result = new GuruEntity();

        result.setId(request.getId());
        result.setName(request.getName());
        result.setTempatMengajar(request.getTempatMengajar());
        result.setUsia(request.getUsia());
        result.setTinggiBadan(request.getTinggiBadan());
        result.setWarnaKulit(request.getWarnaKulit());
        result.setJenisKelamin(request.getJenisKelamin());
        result.setAlamat(request.getAlamat());
    try {
        guruRepo.save(result);
        log.info("Save guru to database successfully");
        return result;

    } catch (Exception e){
        log.error("Save guru to database failed, error",e.getMessage());
        return null;
    }
    }

    @Override
    public GuruEntity delete(Integer id) {
        GuruEntity entity = guruRepo.findById(id).orElse(new GuruEntity());
        if (entity == null){
            log.info("Guru with id : {} not found",id);
            return null;
        }
        try {
            guruRepo.delete(entity);
            log.info("Delete guru from database successfully");
            return entity;

        }catch (Exception e ){
            log.error("Delete guru from database failed",e.getMessage());
            return null;
        }
    }

    @Override
    public GuruEntity update(Integer id, GuruDto request) {
        GuruEntity entity = guruRepo.findById(id).orElse(new GuruEntity());
        if (entity == null){
            log.info("Guru With id : {} not found",id);
            return null;
        }
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setTempatMengajar(request.getTempatMengajar());
        entity.setUsia(request.getUsia());
        entity.setTinggiBadan(request.getTinggiBadan());
        entity.setWarnaKulit(request.getWarnaKulit());
        entity.setJenisKelamin(request.getJenisKelamin());
        entity.setAlamat(request.getAlamat());
    try{
        guruRepo.save(entity);
        log.info("Save guru to database successfully");
        return entity;

    }catch (Exception e){
        log.error("Save guru to database failed,error",e.getMessage());
        return null;
    }
    }
}
