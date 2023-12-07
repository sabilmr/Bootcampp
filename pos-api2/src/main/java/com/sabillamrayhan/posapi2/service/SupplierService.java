package com.sabillamrayhan.posapi2.service;

import com.sabillamrayhan.posapi2.entity.SupplierEntity;
import com.sabillamrayhan.posapi2.model.SupplierModel;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierEntity> getAll();
    Optional<SupplierEntity> getById(Long id);
    Optional<SupplierEntity> save(SupplierModel request);
    Optional<SupplierEntity> update(SupplierModel request, Long id);
    Optional<SupplierEntity> delete(Long id);
}
