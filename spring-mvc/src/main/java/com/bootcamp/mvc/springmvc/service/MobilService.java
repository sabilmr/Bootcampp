package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.MobilEntity;
import com.bootcamp.mvc.springmvc.model.MobilDto;
import com.bootcamp.mvc.springmvc.model.MotorDto;

import java.util.List;

public interface MobilService {
    List<MobilEntity> getAll();
    MobilEntity getById(Integer id);
    MobilEntity save(MobilDto request);
    MobilEntity delete(Integer id);
    MobilEntity update(Integer id, MobilDto request);
}
