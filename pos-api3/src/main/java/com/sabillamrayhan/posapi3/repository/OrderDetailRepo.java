package com.sabillamrayhan.posapi3.repository;

import com.sabillamrayhan.posapi3.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetailEntity, Long> {
    List<OrderDetailEntity> findByOrderId(Long orderId);
}
