package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.SiswaEntity;
import com.bootcamp.mvc.springmvc.model.SiswaDto;

import java.util.List;

public interface SiswaService {
    List<SiswaEntity> getAll();
    SiswaEntity getById(Integer id);
    SiswaEntity save(SiswaDto request);
    SiswaEntity delete(Integer id);
    SiswaEntity update(Integer id, SiswaDto request);
}
