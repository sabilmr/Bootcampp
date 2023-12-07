package com.sabilla.pos.service;

import com.sabilla.pos.entity.SupplierEntity;
import com.sabilla.pos.model.SupplierModel;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierEntity> getAll();
    Optional<SupplierEntity> getById(Long id);
    Optional<SupplierEntity> save(SupplierModel request);
    Optional<SupplierEntity> update(SupplierModel request, Long id);
    Optional<SupplierEntity> delete(Long id);
}
