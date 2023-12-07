package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.KopiEntity;
import com.bootcamp.mvc.springmvc.model.KopiDto;

import java.util.List;

public interface KopiService {
    List<KopiEntity> getAll();
    KopiEntity getById(Integer id);
    KopiEntity save(KopiDto request);
    KopiEntity delete(Integer id);
    KopiEntity update(Integer id, KopiDto request);
}
