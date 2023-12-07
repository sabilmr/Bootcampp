package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.HewanEntity;
import com.bootcamp.belajarspringjpa.model.HewanDto;
import com.bootcamp.belajarspringjpa.model.LeptopDto;
import com.bootcamp.belajarspringjpa.repository.HewanRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HewanServiceImpl implements HewanService{
    private HewanRepo hewanRepo;

    public HewanServiceImpl(HewanRepo hewanRepo) {
        this.hewanRepo = hewanRepo;
    }

    @Override
    public List<HewanEntity> getAll() {
        return hewanRepo.findAll();
    }

    @Override
    public HewanEntity getById(Integer id) {
        return hewanRepo.findById(id).orElse(new HewanEntity());
    }

    @Override
    public HewanEntity save(HewanDto request) {
        HewanEntity result = new HewanEntity();

        result.setId(request.getId());
        result.setName(request.getName());
        result.setMakanan(request.getMakanan());
        result.setKehidupan(request.getKehidupan());
        result.setJenisKulit(request.getJenisKulit());
        result.setCaraBergerak(request.getCaraBergerak());
        result.setCaraBernafas(request.getCaraBernafas());
        result.setBerkembangbiak(request.getBerkembangbiak());
        result.setJumlahKaki(request.getJumlahKaki());
    try {
        hewanRepo.save(result);
        log.info("Save hewan to database successfully");
        return result;

    } catch (Exception e){
        log.error("Save hewan to database failed, error",e.getMessage());
        return null;
    }
    }

    @Override
    public HewanEntity delete(Integer id) {
        HewanEntity entity = hewanRepo.findById(id).orElse(new HewanEntity());
        if (entity == null){
            log.info("Hewan with id : {} not found",id);
            return null;
        }
        try {
            hewanRepo.delete(entity);
            log.info("Delete hewan from database successfully");
            return entity;

        } catch (Exception e){
            log.error("Delete hewan from database failed, error",e.getMessage());
            return null;
        }
    }

    @Override
    public HewanEntity update(Integer id, HewanDto request) {
        HewanEntity entity = hewanRepo.findById(id).orElse(new HewanEntity());
        if (entity == null){
            log.info("Hewan with id : {} not found",id);
            return null;
        }
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setMakanan(request.getMakanan());
        entity.setKehidupan(request.getKehidupan());
        entity.setJenisKulit(request.getJenisKulit());
        entity.setCaraBergerak(request.getCaraBergerak());
        entity.setCaraBernafas(request.getCaraBernafas());
        entity.setBerkembangbiak(request.getBerkembangbiak());
        entity.setJumlahKaki(request.getJumlahKaki());
   try {
       hewanRepo.save(entity);
       log.info("Save hewan to database successfully");
       return entity;

   } catch (Exception e){
       log.error("Save hewan to database failed, error",e.getMessage());
       return null;
   }
    }
}
