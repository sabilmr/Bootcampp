package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.LeptopEntity;
import com.bootcamp.mvc.springmvc.model.LeptopDto;

import java.util.List;

public interface LeptopService  {
    List<LeptopEntity> getAll();
    LeptopEntity getById(Integer id);
    LeptopEntity save(LeptopDto request);
    LeptopEntity delete(Integer id);
    LeptopEntity update(Integer id,LeptopDto request);
}
