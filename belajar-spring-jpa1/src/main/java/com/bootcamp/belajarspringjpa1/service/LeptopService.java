package com.bootcamp.belajarspringjpa1.service;

import com.bootcamp.belajarspringjpa1.entity.LeptopEntity;
import com.bootcamp.belajarspringjpa1.model.LeptopDto;

import java.util.List;

public interface LeptopService {
    List<LeptopEntity> getAll();
    LeptopEntity save(LeptopDto request);
    LeptopEntity delete(Integer id);
    LeptopEntity update(Integer id,LeptopDto request);

}
