package com.bootcamp.webmvc2.service;

import com.bootcamp.webmvc2.entity.HandphoneEntity;
import com.bootcamp.webmvc2.model.HandphoneDto;

import java.util.List;

public interface HandphoneService {
    List<HandphoneEntity> getAll();
    HandphoneEntity getById(Integer id);
    HandphoneEntity save(HandphoneDto request);
    HandphoneEntity delete(Integer id);
    HandphoneEntity update(Integer id,HandphoneDto request);
}
