package com.sabilla.nortwinddapp.service;

import com.sabilla.nortwinddapp.model.entity.LookUpEntity;

import java.util.List;
import java.util.Optional;

public interface LookUpService {
    List<LookUpEntity> getByGroups(String group);
    Optional<LookUpEntity> getByCode(String code);
    Optional<LookUpEntity> getById(String id);
    Optional<LookUpEntity> save(LookUpEntity entity);
    List<LookUpEntity> saveAll(List<LookUpEntity> entities);

}
