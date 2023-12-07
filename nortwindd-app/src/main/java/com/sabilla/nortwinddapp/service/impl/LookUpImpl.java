package com.sabilla.nortwinddapp.service.impl;

import com.sabilla.nortwinddapp.model.entity.LookUpEntity;
import com.sabilla.nortwinddapp.repository.LookupRepo;
import com.sabilla.nortwinddapp.service.LookUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LookUpImpl implements LookUpService {
    private final LookupRepo repo;

    @Override
    public List<LookUpEntity> getByGroups(String group) {
        if (group == null || group.isEmpty()){
            return Collections.emptyList();
        }
        return this.repo.findByGroups(group);
    }

    @Override
    public Optional<LookUpEntity> getByCode(String code) {
        if (code == null || code.isEmpty()){
            return Optional.empty();
        }

        return this.repo.findByCode(code);
    }

    @Override
    public Optional<LookUpEntity> getById(String id) {
        if (id == null || id.isEmpty())
            return Optional.empty();

        return this.repo.findById(id);
    }

    @Override
    public Optional<LookUpEntity> save(LookUpEntity entity) {
        if (entity == null)
            return Optional.empty();
        try {
            this.repo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            log.error("Failed save lookup, error:{}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<LookUpEntity> saveAll(List<LookUpEntity> entities) {
        if (entities.isEmpty())
            return Collections.emptyList();
        try {
            this.repo.saveAll(entities);
            return entities;
        }catch (Exception e){
            log.error("Failed save lookup, error:{}",e.getMessage());
            return Collections.emptyList();
        }
    }
}