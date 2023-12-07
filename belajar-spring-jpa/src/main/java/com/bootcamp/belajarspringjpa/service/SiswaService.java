package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.SiswaEntity;
import com.bootcamp.belajarspringjpa.model.SiswaDto;

import java.util.List;

public interface SiswaService {
    List<SiswaEntity> getAll();
    SiswaEntity getById(Integer id);
    SiswaEntity save(SiswaDto request);
    SiswaEntity delete(Integer id);
    SiswaEntity update(Integer id, SiswaDto request);
}
