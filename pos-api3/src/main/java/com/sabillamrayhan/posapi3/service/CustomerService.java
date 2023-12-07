package com.sabillamrayhan.posapi3.service;

import com.sabillamrayhan.posapi3.entity.CategoryEntity;
import com.sabillamrayhan.posapi3.entity.CustomerEntity;
import com.sabillamrayhan.posapi3.model.CustomerModel;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerModel> getAll();
    Optional<CustomerEntity> getById(Long id);
    Optional<CustomerEntity> save(CustomerModel request);
    Optional<CustomerEntity> update(CustomerModel request, Long id);
    Optional<CustomerEntity> delete(Long id);
}
