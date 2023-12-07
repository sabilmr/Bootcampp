package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.HandphoneEntity;
import com.bootcamp.belajarspringjpa.model.HandphoneDto;

import java.util.List;

public interface HandphoneService {
    List<HandphoneEntity> getAll();
    HandphoneEntity getById(Integer id);
    HandphoneEntity save(HandphoneDto request);
    HandphoneEntity delete(Integer id);
    HandphoneEntity update(Integer id,HandphoneDto request);

}
