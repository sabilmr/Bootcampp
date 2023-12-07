package com.bootcamp.mvc.springmvc.service;


import ch.qos.logback.core.model.INamedModel;
import com.bootcamp.mvc.springmvc.entity.MotorEntity;
import com.bootcamp.mvc.springmvc.model.MotorDto;

import java.util.List;

public interface MotorService {
    List<MotorEntity> getAll();
    MotorEntity getById(Integer id);
    MotorEntity save(MotorDto request);
    MotorEntity delete(Integer id);
    MotorEntity update(Integer id, MotorDto request);
}
