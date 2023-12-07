package com.sabilla.pos.service.impl;

import com.sabilla.pos.entity.CustomerEntity;
import com.sabilla.pos.entity.OrderDetailEntity;
import com.sabilla.pos.entity.OrderEntity;
import com.sabilla.pos.entity.ProductEntity;
import com.sabilla.pos.model.CustomerModel;
import com.sabilla.pos.model.OrderDetailModel;
import com.sabilla.pos.model.OrderModel;
import com.sabilla.pos.repository.CustomerRepo;
import com.sabilla.pos.repository.OrderRepo;
import com.sabilla.pos.repository.ProductRepo;
import com.sabilla.pos.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;

    @Override
    public List<OrderModel> getAll() {
        List<OrderEntity> result = this.orderRepo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(OrderModel::new).collect(Collectors.toList());
    }

    @Override
    public Optional<OrderModel> getById(Long id) {
        if(id == 0L)
            return Optional.empty();
        var result = this.orderRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        OrderModel orderModel= new OrderModel(result);
        return Optional.of(orderModel);
    }

    @Override
    public List<OrderModel> getByCustomerId(Long customerId) {
        if(customerId == 0L){
            return Collections.emptyList();
        }

        var result = this.orderRepo.findByCustomerId(customerId);
        return result.stream().map(OrderModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OrderModel> getByInvoiceNo(String invoiceNo) {
        if(invoiceNo == null || invoiceNo.isEmpty())
            return Optional.empty();

        var result = this.orderRepo.findByInvoiceNo(invoiceNo).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        OrderModel orderModel = new OrderModel(result);
        return Optional.of(orderModel);
    }

    @Override
    public Optional<OrderModel> save(OrderModel request) {
        if (request.getCustomer()== null){
            log.error("Save order failed, customer not found");
            return Optional.empty();
        }

        CustomerEntity customer = this.getCustomer(request.getCustomer());
        if (customer == null){
            log.error("Save order failed, customer not found");
            return Optional.empty();
        }

        boolean productIsValid = this.isProductValid(request.getOrderDetail());
        if (!productIsValid){
            log.error("Save order failed, product not valid");
            return Optional.empty();
        }

        OrderEntity entity = this.newOrder(request,customer.getId());
        try {
            this.orderRepo.saveAndFlush(entity);

            OrderModel response = new OrderModel(entity);
            return Optional.of(response);

        }catch (Exception e){
            log.error("Save order failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    private OrderEntity newOrder(OrderModel request, Long customerId) {
        OrderEntity order = new OrderEntity();

        BeanUtils.copyProperties(request.getShip(), order);

        order.setInvoiceNo(request.getInvoiceNo());

        order.setCustomerId(customerId);
        // set invoice
        order.setOrderDate(new Date());

        Double grandTotal = 0.0;
        for (OrderDetailModel detail: request.getOrderDetail()){

            OrderDetailEntity detailEntity = new OrderDetailEntity(order, detail.getProductId(), detail.getPrice(), detail.getQuantity());

            order.addDetail(detailEntity);

            grandTotal += detailEntity.getSubTotal();
        }
        order.setGrandTotal(grandTotal);
        return order;
    }

    private boolean isProductValid(List<OrderDetailModel> details) {
        List<Long> ids = details.stream().map(OrderDetailModel::getProductId).collect(Collectors.toList());

        List<ProductEntity> products = productRepo.findByIdIn(ids);

        if (products.isEmpty()){
            return false;
        }
        for (ProductEntity product: products){
            var detailModel = details.stream()
                    .filter(detail -> detail.getProductId() == product.getId())
                    .findFirst().orElse(null);
            if (detailModel == null){
                return false;
            }
            if (product.getStock() < detailModel.getQuantity()){
                return false;
            }
        }
        return true;
    }

    private CustomerEntity getCustomer(CustomerModel request) {
        if (request.getId() == null){
            return null;
        }
        var result = customerRepo.findByEmail(request.getEmail()).orElse(null);

        if (result == null) {
            CustomerEntity customer = new CustomerEntity();

            BeanUtils.copyProperties(request, customer);
            try {
                customerRepo.saveAndFlush(customer);
                return customer;
            }catch (Exception e){
                log.error("Save customer failed, error: {}",e.getMessage());
                return null;
            }
        }
        return result;
    }

    @Override
    public Optional<OrderEntity> update(OrderModel request, Long id) {
        if(id == 0L)
            return Optional.empty();

        OrderEntity entity = this.orderRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        BeanUtils.copyProperties(request, entity);
        try {
            this.orderRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<OrderEntity> delete(Long id) {
        if(id == 0L)
            return Optional.empty();

        OrderEntity entity = this.orderRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        try {
            this.orderRepo.delete(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
