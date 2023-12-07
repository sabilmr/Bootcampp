package com.bootcamp.belajarspringjpa1.service;

import com.bootcamp.belajarspringjpa1.entity.LeptopEntity;
import com.bootcamp.belajarspringjpa1.model.LeptopDto;
import com.bootcamp.belajarspringjpa1.repository.LeptopRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LeptopServiceImpl implements LeptopService {
    private final LeptopRepo leptopRepo;

    public LeptopServiceImpl(LeptopRepo leptopRepo) {
        this.leptopRepo = leptopRepo;
    }

    @Override
    public List<LeptopEntity> getAll() {
        return leptopRepo.findAll();
    }

    @Override
    public LeptopEntity save(LeptopDto request) {
        LeptopEntity result = new LeptopEntity();

        BeanUtils.copyProperties(request,result);
    try {
        leptopRepo.save(result);
        log.info("Save product to database successfully");
        return result;

    } catch (Exception e){
        log.error("Save product to database failed error {}",e.getMessage());
        return null;
    }

}

    @Override
    public LeptopEntity delete(Integer id) {
        LeptopEntity entity = leptopRepo.findById(id).orElse(new LeptopEntity());
        if (entity == null){
            log.warn("Leptop with id : {} not found",id);
            return null;
        }
    try {
        leptopRepo.delete(entity);
        log.info("Delete leptop to database is successfully");
        return entity;

    } catch (Exception e){
        log.error("Delete leptop to database is failed,erorr : {}",e.getMessage());
        return null;
    }
    }

    @Override
    public LeptopEntity update(Integer id, LeptopDto request) {
        LeptopEntity entity = leptopRepo.findById(id).orElse(new LeptopEntity());
        if (entity == null){
            log.warn("Leptop with id : {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
    try {
        leptopRepo.save(entity);
        log.info("Save leptop to database is successfully");
        return entity;

    } catch (Exception e){
        log.error("Save leptop to database is failed,erorr : {}",e.getMessage());
        return null;
    }
    }


}
