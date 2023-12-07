package com.sabilla.pos.service;

import com.sabilla.pos.entity.CustomerEntity;
import com.sabilla.pos.model.CustomerModel;
import com.sabilla.pos.model.response.CustomerResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerResponse> getAll();
    Optional<CustomerEntity> getById(Long id);
    Optional<CustomerEntity> save(CustomerModel request);
    Optional<CustomerEntity> update(CustomerModel request, Long id);
    Optional<CustomerEntity> delete(Long id);
}
