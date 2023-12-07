package com.bootcamp.webmvc2.service;

import com.bootcamp.webmvc2.entity.MotorEntity;
import com.bootcamp.webmvc2.model.MotorDto;

import java.util.List;

public interface MotorService {
    List<MotorEntity> getAll();
    MotorEntity getById(Integer id);
    MotorEntity save(MotorDto request);
    MotorEntity delete(Integer id);
    MotorEntity update(Integer id, MotorDto request);
}
