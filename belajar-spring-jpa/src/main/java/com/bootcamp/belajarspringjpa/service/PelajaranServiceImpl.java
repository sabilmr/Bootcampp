package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.PelajaranEntity;
import com.bootcamp.belajarspringjpa.model.PelajaranDto;
import com.bootcamp.belajarspringjpa.repository.PelajaranRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PelajaranServiceImpl implements PelajaranService{
    private PelajaranRepo pelajaranRepo;

    public PelajaranServiceImpl(PelajaranRepo pelajaranRepo) {
        this.pelajaranRepo = pelajaranRepo;
    }

    @Override
    public List<PelajaranEntity> getAll() {
        return pelajaranRepo.findAll();
    }

    @Override
    public PelajaranEntity getById(Integer id) {
        return pelajaranRepo.findById(id).orElse(new PelajaranEntity());
    }

    @Override
    public PelajaranEntity save(PelajaranDto request) {
        PelajaranEntity result = new PelajaranEntity();

        result.setId(request.getId());
        result.setHari(request.getHari());
        result.setMataPelajaran(request.getMataPelajaran());
        result.setJam(request.getJam());
        result.setGuru(request.getGuru());
    try {
        pelajaranRepo.save(result);
        log.info("Save pelajaran to database successfully");
        return result;

    } catch (Exception e){
        log.error("Save pelajaran to database failed, error",e.getMessage());
        return null;
    }
    }

    @Override
    public PelajaranEntity delete(Integer id) {
        PelajaranEntity entity = pelajaranRepo.findById(id).orElse(new PelajaranEntity());
        if (entity == null){
            log.info("Pelajaran with id : {} not found",id);
            return null;
        }
        try {
            pelajaranRepo.delete(entity);
            log.info("Delete pelajaran from database successfully");
            return entity;

        }catch (Exception e){
            log.error("Delete Pelajaran from database failed, error",e.getMessage());
            return null;
        }
    }

    @Override
    public PelajaranEntity update(Integer id, PelajaranDto request) {
        PelajaranEntity entity = pelajaranRepo.findById(id).orElse(new PelajaranEntity());
        if (entity == null){
            log.info("Pelajaran with id : {} not found",id);
            return null;
        }
        entity.setId(request.getId());
        entity.setHari(request.getHari());
        entity.setMataPelajaran(request.getMataPelajaran());
        entity.setJam(request.getJam());
        entity.setGuru(request.getGuru());

    try {
        pelajaranRepo.save(entity);
        log.info("Save pelajaran to database successfully");
        return entity;

    }catch (Exception e){
        log.error("Save pelajaran to database failed, error",e.getMessage());
        return null;
    }
    }
}
