package com.sabilla.nortwinddapp.service;

import com.sabilla.nortwinddapp.model.response.SupplierResponse;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierResponse> getAll();
    SupplierResponse getById(String id);
    Optional<SupplierResponse> save(SupplierResponse request);
    Optional<SupplierResponse> update(SupplierResponse request, String id);
    Optional<SupplierResponse> delete(String id);
}