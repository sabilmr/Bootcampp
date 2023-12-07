package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.MobilEntity;
import com.bootcamp.belajarspringjpa.model.MobilDto;
import com.bootcamp.belajarspringjpa.repository.MobilRepo;

import java.util.List;

public interface MobilServie {

    List<MobilEntity> getAll();
    MobilEntity getById(Integer id);
    MobilEntity save(MobilDto request);
    MobilEntity delete(Integer id);
    MobilEntity update(Integer id, MobilDto request);
}
