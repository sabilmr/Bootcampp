package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.SepedaEntity;
import com.bootcamp.belajarspringjpa.model.SepedaDto;
import com.bootcamp.belajarspringjpa.repository.SepedaRepo;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface SepedaService {
    List<SepedaEntity> getAll();
    SepedaEntity getById (Integer id);
    SepedaEntity save(SepedaDto request);
    SepedaEntity delete(Integer id);
    SepedaEntity update(Integer id,SepedaDto request);
}
