package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.MobilEntity;
import com.bootcamp.belajarspringjpa.model.MobilDto;
import com.bootcamp.belajarspringjpa.repository.MobilRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MobilServiceImpl implements MobilServie{
    private MobilRepo mobilRepo;

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

        result.setId(request.getId());
        result.setNameKendaraan(request.getNamaKendaraan());
        result.setJenisKendaran(request.getJenisKendaraan());
        result.setHarga(request.getHarga());
        result.setWarna(request.getWarna());
        result.setRoda(request.getRoda());
        result.setPlatNomer(request.getPlatNomer());
        result.setCc(request.getCc());
        result.setBahanBakar(request.getBahanBakar());

   try {
       mobilRepo.save(result);
       log.info("Save mobil to database successfully");
       return result;

   } catch (Exception e){
       log.error("Save mobil to database failed, error",e.getMessage());
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
            log.info("Delete mobil from database successfully");
            return entity;

        } catch (Exception e){
            log.error("Delete mobil from database failed, error",e.getMessage());
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
        entity.setId(request.getId());
        entity.setNameKendaraan(request.getNamaKendaraan());
        entity.setJenisKendaran(request.getJenisKendaraan());
        entity.setHarga(request.getHarga());
        entity.setWarna(request.getWarna());
        entity.setRoda(request.getRoda());
        entity.setPlatNomer(request.getPlatNomer());
        entity.setCc(request.getCc());
        entity.setBahanBakar(request.getBahanBakar());
    try {
        mobilRepo.save(entity);
        log.info("Save mobil to database successfully");
        return entity;

    } catch (Exception e){
        log.info("Save mobil database failed, error",e.getMessage());
        return null;
    }
    }
}
