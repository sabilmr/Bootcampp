package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.GuruEntity;
import com.bootcamp.belajarspringjpa.model.GuruDto;

import java.util.List;

public interface GuruService {
    List<GuruEntity> getAll();
    GuruEntity getById(Integer id);
    GuruEntity save(GuruDto request);
    GuruEntity delete(Integer id);
    GuruEntity update(Integer id,GuruDto request);
}
