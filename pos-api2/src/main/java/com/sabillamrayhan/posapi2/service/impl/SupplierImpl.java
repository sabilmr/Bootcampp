package com.sabillamrayhan.posapi2.service.impl;

import com.sabillamrayhan.posapi2.entity.SupplierEntity;
import com.sabillamrayhan.posapi2.model.SupplierModel;
import com.sabillamrayhan.posapi2.repository.SupplierRepo;
import com.sabillamrayhan.posapi2.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SupplierImpl implements SupplierService {
    private final SupplierRepo supplierRepo;
    @Override
    public List<SupplierEntity> getAll() {
         return supplierRepo.findAll();
    }

    @Override
    public Optional<SupplierEntity> getById(Long id) {
        if (id == 0L)
            return Optional.empty();
        return supplierRepo.findById(id);
    }

    @Override
    public Optional<SupplierEntity> save(SupplierModel request) {
        SupplierEntity entity = new SupplierEntity();
        BeanUtils.copyProperties(request, entity);
        try {
            supplierRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception sabil){
            log.error("Save supplier failed, error: {}",sabil.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierEntity> update(SupplierModel request, Long id) {
        if (id == 0L)
            return Optional.empty();
        SupplierEntity entity = supplierRepo.findById(id).orElse(null);
        if (entity == null)
            return Optional.empty();
        BeanUtils.copyProperties(request,entity);
        try {
            supplierRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception sabil){
            log.error("Save supplier failed, error: {}",sabil.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierEntity> delete(Long id) {
        if (id == 0L)
            return Optional.empty();
        SupplierEntity entity = supplierRepo.findById(id).orElse(null);
        if (entity == null)
            return Optional.empty();
        try {
            supplierRepo.delete(entity);
            return Optional.of(entity);
        }catch (Exception sabil){
            log.error("Delete supplier failed, error: {}",sabil.getMessage());
            return Optional.empty();
        }
    }
}
