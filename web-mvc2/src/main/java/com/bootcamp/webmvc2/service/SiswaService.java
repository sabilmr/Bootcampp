package com.bootcamp.webmvc2.service;

import com.bootcamp.webmvc2.entity.SiswaEntity;
import com.bootcamp.webmvc2.model.SiswaDto;

import java.util.List;

public interface SiswaService {
    List<SiswaEntity> getAll();
    SiswaEntity getById(Integer id);
    SiswaEntity save(SiswaDto request);
    SiswaEntity delete(Integer id);
    SiswaEntity update(Integer id,SiswaDto request);
}
