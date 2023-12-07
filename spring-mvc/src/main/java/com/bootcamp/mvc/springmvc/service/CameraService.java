package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.CameraEntity;
import com.bootcamp.mvc.springmvc.model.CameraDto;

import java.util.List;

public interface CameraService {
    List<CameraEntity> getAll();
    CameraEntity getById(Integer id);
    CameraEntity save(CameraDto request);
    CameraEntity delete(Integer id);
    CameraEntity update(Integer id, CameraDto request);
}
