package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.HewanEntity;
import com.bootcamp.belajarspringjpa.model.HewanDto;
import com.bootcamp.belajarspringjpa.model.LeptopDto;
import com.bootcamp.belajarspringjpa.repository.HewanRepo;

import java.util.List;

public interface HewanService {
    List<HewanEntity> getAll();
    HewanEntity getById(Integer id);
    HewanEntity save(HewanDto request);
    HewanEntity delete(Integer id);
    HewanEntity update(Integer id,HewanDto request);
}
