package com.sabillamrayhan.posapi2.repository;

import com.sabillamrayhan.posapi2.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findByInvoiceNo(String invoiceNo);
    List<OrderEntity> findByCustomerId(Long customerId);
}
