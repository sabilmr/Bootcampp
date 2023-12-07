package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.HandphoneEntity;
import com.bootcamp.mvc.springmvc.model.HandphoneDto;
import com.bootcamp.mvc.springmvc.model.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
public interface HandphoneService {
    List<HandphoneEntity> getAll();
    HandphoneEntity getById (Integer id);
    HandphoneEntity save (HandphoneDto request);
    HandphoneEntity delete(Integer id);
    HandphoneEntity update (Integer id,HandphoneDto request);
}
