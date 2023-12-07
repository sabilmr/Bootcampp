package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.SiswaEntity;
import com.bootcamp.belajarspringjpa.model.SiswaDto;
import com.bootcamp.belajarspringjpa.repository.SiswaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SiswaServiceImpl implements SiswaService{
    private SiswaRepo siswaRepo;

    public SiswaServiceImpl(SiswaRepo siswaRepo) {
        this.siswaRepo = siswaRepo;
    }

    @Override
    public List<SiswaEntity> getAll() {
        return siswaRepo.findAll();
    }

    @Override
    public SiswaEntity getById(Integer id) {
        return siswaRepo.findById(id).orElse(new SiswaEntity());
    }

    @Override
    public SiswaEntity save(SiswaDto request) {
        SiswaEntity result = new SiswaEntity();
        result.setId(request.getId());
        result.setName(request.getName());
        result.setTempatKuliah(request.getTempatKuliah());
        result.setJurusan(request.getJurusan());
        result.setUsia(request.getUsia());
        result.setWarnaKulit(request.getWarnaKulit());
        result.setTinggiBadan(request.getTinggiBadan());
        result.setJenisKelamin(request.getJenisKelamin());
        result.setAlamat(request.getAlamat());

    try {
       siswaRepo.save(result);
       log.info("Save siswa to database successfully");
       return result;

    } catch (Exception e){
        log.error("Save siswa to database failed, error {}",e.getMessage());
        return null;
    }
    }

    @Override
    public SiswaEntity delete(Integer id) {
        SiswaEntity entity = siswaRepo.findById(id).orElse(new SiswaEntity());
        if (entity == null) {
            log.info("Siswa with id {} : not found", id);
            return null;
        }
    try {
        siswaRepo.delete(entity);
        log.info("Delete siswa from database successfully");
        return entity;

    } catch (Exception e){
        log.error("Delete siswa from database failed, error",e.getMessage());
        return null;
    }
    }

    @Override
    public SiswaEntity update(Integer id, SiswaDto request) {
        SiswaEntity entity = siswaRepo.findById(id).orElse(new SiswaEntity());
        if (entity == null){
            log.info("Siswa with id {} : not found", id);
            return null;
        }
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setTempatKuliah(request.getTempatKuliah());
        entity.setJurusan(request.getJurusan());
        entity.setUsia(request.getUsia());
        entity.setWarnaKulit(request.getWarnaKulit());
        entity.setTinggiBadan(request.getTinggiBadan());
        entity.setJenisKelamin(request.getJenisKelamin());
        entity.setAlamat(request.getAlamat());
    try {
        siswaRepo.save(entity);
        log.info("Save siswa to database successfully");
        return entity;

    } catch (Exception e){
        log.error("Save siswa to database failed, error {}",e.getMessage());
        return null;
    }
    }

}
