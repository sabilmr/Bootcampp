package com.sabilla.nortwinddapp.service.impl;

import com.sabilla.nortwinddapp.model.entity.SupplierEntity;
import com.sabilla.nortwinddapp.model.response.SupplierResponse;
import com.sabilla.nortwinddapp.repository.SupplierRepo;
import com.sabilla.nortwinddapp.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SupplierImpl implements SupplierService {
    private final SupplierRepo supplierRepo;
    @Override
    public List<SupplierResponse> getAll() {
        return supplierRepo.findAll().stream()
                .map(SupplierResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierResponse getById(String id) {
        if (id == null){
            return null;
        }
        return supplierRepo.findById(id)
                .map(SupplierResponse::new)
                .orElse(null);
    }

    @Override
    public Optional<SupplierResponse> save(SupplierResponse response) {
        if (response == null){
            return Optional.empty();
        }

        SupplierEntity entity = new SupplierEntity(response);
        try {
            supplierRepo.save(entity);
            log.info("Save supplier success");
            return Optional.of(new SupplierResponse());
        }catch (Exception e){
            log.error("Save supplier failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierResponse> update(SupplierResponse response, String id) {
        SupplierEntity entity = supplierRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        BeanUtils.copyProperties(response, entity);
        try {
            supplierRepo.save(entity);
            log.info("Update supplier success");
            return Optional.of(new SupplierResponse());
        }catch (Exception e){
            log.error("Update supplier failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierResponse> delete(String id) {
        SupplierEntity entity = supplierRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Delete supplier with id not found : {}", id);
            return Optional.empty();
        }
        try {
            supplierRepo.delete(entity);
            log.info("Delete supplier success");
            return Optional.of(new SupplierResponse());
        }catch (Exception e){
            log.error("Delete supplier failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}