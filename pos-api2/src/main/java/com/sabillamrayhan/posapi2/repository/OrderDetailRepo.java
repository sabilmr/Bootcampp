package com.sabillamrayhan.posapi2.repository;

import com.sabillamrayhan.posapi2.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetailEntity, Long> {
    List<OrderDetailEntity> findByOrderId(Long orderId);
}
