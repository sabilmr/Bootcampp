package com.bootcamp.webmvc2.service;

import com.bootcamp.webmvc2.entity.SepedaEntity;
import com.bootcamp.webmvc2.model.SepedaDto;

import java.util.List;

public interface SepedaService {
    List<SepedaEntity> getAll();
    SepedaEntity getById(Integer id);
    SepedaEntity save(SepedaDto request);
    SepedaEntity delete(Integer id);
    SepedaEntity update(Integer id, SepedaDto request);
}
