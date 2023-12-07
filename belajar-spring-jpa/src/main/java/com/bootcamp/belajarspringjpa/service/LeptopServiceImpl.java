package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.LeptopEntity;
import com.bootcamp.belajarspringjpa.model.LeptopDto;
import com.bootcamp.belajarspringjpa.repository.LeptopRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LeptopServiceImpl implements LeptopService {
    private LeptopRepo leptopRepo;

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

        result.setId(request.getId());
        result.setName(request.getName());
        result.setProsesor(request.getProsesor());
        result.setRam(request.getRam());
        result.setBatrai(request.getBatrai());
        result.setMemori(request.getMemori());
        result.setWarna(request.getWarna());
        result.setSistemOperasi(request.getSistemOperasi());
        result.setDimensi(request.getDimensi());
        result.setLayar(request.getLayar());
        result.setRilis(request.getRilis());
        result.setHarga(request.getHarga());
        try {
            leptopRepo.save(result);
            log.info("Save leptop to database successfully");
            return result;
        } catch (Exception e) {
            log.error("Save leptop to database failed, error", e.getMessage());
            return null;
        }
    }

    @Override
    public LeptopEntity delete(Integer id) {
        LeptopEntity entity = leptopRepo.findById(id).orElse(new LeptopEntity());
        if (entity == null) {
            log.info("Leptop with id : {} not found", id);
            return null;
        }
        try {
            leptopRepo.delete(entity);
            log.info("Delete leptop from database successfully");
            return entity;

        } catch (Exception e){
            log.error("Delete leptop from database failed, error",e.getMessage());
            return null;
        }
    }

    @Override
    public LeptopEntity update(Integer id, LeptopDto request) {
        LeptopEntity entity = leptopRepo.findById(id).orElse(new LeptopEntity());
        if (entity == null){
            log.info("Leptop with id : {} not found");
            return null;
        }
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setProsesor(request.getProsesor());
        entity.setRam(request.getRam());
        entity.setBatrai(request.getBatrai());
        entity.setMemori(request.getMemori());
        entity.setWarna(request.getWarna());
        entity.setSistemOperasi(request.getSistemOperasi());
        entity.setDimensi(request.getDimensi());
        entity.setLayar(request.getLayar());
        entity.setRilis(request.getRilis());
        entity.setHarga(request.getHarga());
    try {
        leptopRepo.save(entity);
        log.info("Save leptop to database successfully");
        return entity;

    } catch (Exception e){
        log.error("Save leptop to database failed, error",e.getMessage());
        return null;
    }
    }
}