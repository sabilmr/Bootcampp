package com.sabillamrayhan.posapi2.service;

import com.sabillamrayhan.posapi2.entity.CategoryEntity;
import com.sabillamrayhan.posapi2.entity.CustomerEntity;
import com.sabillamrayhan.posapi2.model.CustomerModel;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerModel> getAll();
    Optional<CustomerModel> getById(Long id);
    Optional<CustomerEntity> save(CustomerModel request);
    Optional<CustomerEntity> update(CustomerModel request, Long id);
    Optional<CustomerEntity> delete(Long id);
}
