package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.LeptopEntity;
import com.bootcamp.belajarspringjpa.model.LeptopDto;

import java.util.List;

public interface LeptopService {
    List<LeptopEntity> getAll();
    LeptopEntity getById(Integer id);
    LeptopEntity save(LeptopDto request);
    LeptopEntity delete(Integer id);
    LeptopEntity update(Integer id, LeptopDto request);
}
