package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.SepedaEntity;
import com.bootcamp.belajarspringjpa.model.SepedaDto;
import com.bootcamp.belajarspringjpa.repository.SepedaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SepedaServiceImpl implements SepedaService{

    private SepedaRepo sepedaRepo;

    public SepedaServiceImpl(SepedaRepo sepedaRepo) {
        this.sepedaRepo = sepedaRepo;
    }

    @Override
    public List<SepedaEntity> getAll() {
        return sepedaRepo.findAll();
    }

    @Override
    public SepedaEntity getById(Integer id) {
        return sepedaRepo.findById(id).orElse(new SepedaEntity());
    }

    @Override
    public SepedaEntity save(SepedaDto request) {
        SepedaEntity result = new SepedaEntity();
        result.setId(request.getId());
        result.setNameKendaraan(request.getNameKendaraan());
        result.setJenisKendaraan(request.getJenisKendaraan());
        result.setRoda(request.getRoda());
        result.setUkuranRodaDepan(request.getUkuranRodaDepan());
        result.setUkuranRodaBelakang(request.getUkuranRodaBelakang());
        result.setPlatNomor(request.getPlatNomor());
        result.setBahanBakar(request.getBahanBakar());
        result.setCc(request.getCc());
        result.setTipeMesin(request.getTipeMesin());
        result.setDayaMaksimum(request.getDayaMaksimum());
        result.setTorsiMaksimum(request.getTorsiMaksimum());
        result.setHarga(request.getHarga());

   try {
       sepedaRepo.save(result);
       log.info("Save sepeda to database successfully");
       return result;

   } catch (Exception e){
       log.error("save sepeda to database failed, error {}",e.getMessage());
       return null;
   }
    }

    @Override
    public SepedaEntity delete(Integer id) {
        SepedaEntity entity = sepedaRepo.findById(id).orElse(new SepedaEntity());
        if (entity == null){
            log.info("Sepeda with id : {} not found",id);
            return null;
        }
        try {
            sepedaRepo.delete(entity);
            log.info("Delete from database successfully");
            return entity;

        } catch (Exception e){
            log.error("Delete from database failed, error",e.getMessage());
            return null;
        }
    }

    @Override
    public SepedaEntity update(Integer id, SepedaDto request) {
        SepedaEntity entity = sepedaRepo.findById(id).orElse(new SepedaEntity());
        if (entity == null){
            log.info("Sepeda with id : {} not found",id);
            return null;
        }
        entity.setId(request.getId());
        entity.setNameKendaraan(request.getNameKendaraan());
        entity.setJenisKendaraan(request.getJenisKendaraan());
        entity.setRoda(request.getRoda());
        entity.setUkuranRodaDepan(request.getUkuranRodaDepan());
        entity.setUkuranRodaBelakang(request.getUkuranRodaBelakang());
        entity.setPlatNomor(request.getPlatNomor());
        entity.setBahanBakar(request.getBahanBakar());
        entity.setCc(request.getCc());
        entity.setTipeMesin(request.getTipeMesin());
        entity.setDayaMaksimum(request.getDayaMaksimum());
        entity.setTorsiMaksimum(request.getTorsiMaksimum());
        entity.setHarga(request.getHarga());

    try {
        sepedaRepo.save(entity);
        log.info("Save sepeda to database successfully");
        return entity;

    } catch (Exception e){
        log.error("Save sepeda to database failes, error",e.getMessage());
        return null;
    }
    }
}
