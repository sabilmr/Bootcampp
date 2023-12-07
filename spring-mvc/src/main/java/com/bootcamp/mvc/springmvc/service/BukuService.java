package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.BukuEntity;
import com.bootcamp.mvc.springmvc.model.BukuDto;

import java.util.List;

public interface BukuService {
    List<BukuEntity> getAll();
    BukuEntity getById(Integer id);
    BukuEntity save(BukuDto request);
    BukuEntity delete(Integer id);
    BukuEntity update(Integer id, BukuDto request);
}
