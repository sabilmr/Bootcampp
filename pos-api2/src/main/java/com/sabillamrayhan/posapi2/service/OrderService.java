package com.sabillamrayhan.posapi2.service;

import com.sabillamrayhan.posapi2.entity.OrderEntity;
import com.sabillamrayhan.posapi2.model.OrderModel;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderModel> getAll();
    Optional<OrderModel> getById(Long id);
    List<OrderModel> getByCustomerId(Long customerId);
    Optional<OrderModel> getByInvoiceNo(String invoiceNo);
    Optional<OrderModel> save(OrderModel request);
    Optional<OrderEntity> update(OrderModel request, Long id);
    Optional<OrderEntity> delete(Long id);
}
