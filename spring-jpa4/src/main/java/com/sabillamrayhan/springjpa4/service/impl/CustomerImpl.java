package com.sabillamrayhan.springjpa4.service.impl;

import com.sabillamrayhan.springjpa4.entity.CustomerEntity;
import com.sabillamrayhan.springjpa4.model.CustomerModel;
import com.sabillamrayhan.springjpa4.repository.CustomerRepo;
import com.sabillamrayhan.springjpa4.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    @Override
    public List<CustomerModel> gets() {
        List<CustomerEntity> result = customerRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream()
                .map(CustomerModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerModel> getById(Long id) {
        CustomerEntity entity = customerRepo.findById(id).orElse(null);
        if (entity == null)
            return Optional.empty();

        CustomerModel model = new CustomerModel(entity);
        return Optional.of(model);
    }

    @Override
    public void save(CustomerModel request) {
        if (customerRepo.existsByAccountNo(request.getAccountNo())) {
            log.warn("Save customer failed, error account number with {} is exist", request.getAccountNo());
            return;
        }

        CustomerEntity entity = new CustomerEntity();
        BeanUtils.copyProperties(request, entity);
        try {
            customerRepo.save(entity);
            log.info("Save customer success");
        }catch (Exception sabil){
            log.error("Save customer failed, error: {}",sabil.getMessage());
        }
    }

    @Override
    public void update(CustomerModel request, Long id) {
        CustomerEntity entity = customerRepo.findById(id).orElse(null);
        if (entity == null) {
            return;
        }
        BeanUtils.copyProperties(request,entity);
        entity.setId(id);
        try {
            customerRepo.save(entity);
            log.info("Update customer success");
        }catch (Exception sabil){
            log.error("Update customer failed, error: {}",sabil.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        CustomerEntity entity = customerRepo.findById(id).orElse(null);
        if (entity == null){
            return;
        }
        try {
            customerRepo.delete(entity);
            log.info("Delete customer success");
        }catch (Exception sabil){
            log.error("Delete customer failed, error: {}",sabil.getMessage());
        }
    }
}
