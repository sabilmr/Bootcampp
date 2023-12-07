package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.GuruEntity;
import com.bootcamp.mvc.springmvc.model.GuruDto;

import java.util.List;

public interface GuruService {
    List<GuruEntity> getAll();
    GuruEntity getById(Integer id);
    GuruEntity save(GuruDto request);
    GuruEntity delete(Integer id);
    GuruEntity update(Integer id, GuruDto request);
}
