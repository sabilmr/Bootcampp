package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.SiswaEntity;
import com.bootcamp.mvc.springmvc.model.SiswaDto;
import com.bootcamp.mvc.springmvc.repository.SiswaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SiswaServiceImpl implements SiswaService{
    private final SiswaRepo siswaRepo;

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

        BeanUtils.copyProperties(request,result);
   try {
       siswaRepo.save(result);
       log.info("Save siswa to database is successfully");
       return result;

   } catch (Exception ex){
       log.error("Save siswa to database is failed,error : {}",ex.getMessage());
       return null;
   }
    }

    @Override
    public SiswaEntity delete(Integer id) {
        SiswaEntity entity = siswaRepo.findById(id).orElse(new SiswaEntity());
        if(entity == null){
            log.warn("Siswa with id : {} not found",id);
            return null;
        }
   try {
       siswaRepo.delete(entity);
       log.info("Delete siswa to database is successfully");
       return entity;

   } catch (Exception ex){
       log.error("Delete siswa to database is failed,error : {}",ex.getMessage());
       return null;
   }
    }

    @Override
    public SiswaEntity update(Integer id, SiswaDto request) {
        SiswaEntity entity = siswaRepo.findById(id).orElse(new SiswaEntity());
        if(entity == null){
            log.warn("Siswa with id : {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
    try {
        siswaRepo.save(entity);
        log.info("Save siswa to database is successfully");
        return entity;

    } catch (Exception ex){
        log.error("Save siswa to database is failed,error : {}",ex.getMessage());
        return null;
    }
    }
}
