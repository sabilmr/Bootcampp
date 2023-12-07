package com.sabillamrayhan.posapi3.service.impl;

import com.sabillamrayhan.posapi3.entity.CustomerEntity;
import com.sabillamrayhan.posapi3.entity.OrderDetailEntity;
import com.sabillamrayhan.posapi3.entity.OrderEntity;
import com.sabillamrayhan.posapi3.entity.ProductEntity;
import com.sabillamrayhan.posapi3.model.CustomerModel;
import com.sabillamrayhan.posapi3.model.OrderDetailModel;
import com.sabillamrayhan.posapi3.model.OrderModel;
import com.sabillamrayhan.posapi3.repository.CustomerRepo;
import com.sabillamrayhan.posapi3.repository.OrderRepo;
import com.sabillamrayhan.posapi3.repository.ProductRepo;
import com.sabillamrayhan.posapi3.service.OrderService;
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
@Slf4j
@RequiredArgsConstructor
public class OrderImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    @Override
    public List<OrderModel> getAll() {
        List<OrderEntity> result = orderRepo.findAll();
        if (result.isEmpty()) {
            return Collections.emptyList();
        }
        return result.stream().map(OrderModel::new).collect(Collectors.toList());
    }

    @Override
    public Optional<OrderModel> getById(Long id) {
        if (id == 0L)
            return Optional.empty();
        var result = orderRepo.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }
        OrderModel orderModel = new OrderModel(result);
        return Optional.of(orderModel);
    }

    @Override
    public List<OrderModel> getByCustomerId(Long customerId) {
        if (customerId == 0L) {
            return Collections.emptyList();
        }
        var result = orderRepo.findByCustomerId(customerId);
        return result.stream().map(OrderModel::new).collect(Collectors.toList());
    }

    @Override
    public Optional<OrderModel> getByInvoiceNo(String invoiceNo) {
        if (invoiceNo == null || invoiceNo.isEmpty())
            return Optional.empty();
        var result = orderRepo.findByInvoiceNo(invoiceNo).orElse(null);
        if (result == null){
            return Optional.empty();
        }
        OrderModel orderModel = new OrderModel(result);
        return Optional.of(orderModel);

    }

    @Override
    public Optional<OrderModel> save(OrderModel request) {
        if (request.getCustomer() == null){
            log.error("Save order failed, customer is null");
            return Optional.empty();
        }

        CustomerEntity customer = this.getCustomer(request.getCustomer());
        if (customer == null){
            log.error("Save order failed, customer not found");
            return Optional.empty();
        }

        boolean productIsValid = this.productIsValid(request.getOrderDetail());
        if (!productIsValid){
            log.error("Save order failed, product not found");
            return Optional.empty();
        }
        //get new Order Entity
        //call method new order
        OrderEntity entity = this.newOrder(request, customer.getId());
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
        order.setOrderDate( new Date());

        Double grandTotal = 0.0;
        for (OrderDetailModel detail: request.getOrderDetail()){
            //call constructor OrderDetailEntity
            OrderDetailEntity detailEntity = new OrderDetailEntity(order, detail.getProductId(), detail.getPrice(), detail.getQuantity());
            //call method addDetail
            order.addDetail(detailEntity);
            //grandTotal plus subTotal
            grandTotal += detailEntity.getSubTotal();
        }
        //set grandTotal
        order.setGrandTotal(grandTotal);
        return order;
    }

    private boolean productIsValid(List<OrderDetailModel> details) {
        // get product id dari list
        List<Long> ids = details.stream().map(OrderDetailModel::getProductId)
                .collect(Collectors.toList());
        // get product dari database
        List<ProductEntity> products = productRepo.findByIdIn(ids);
        // jika product di database kosong, return tidak valid
        if (products.isEmpty()){
            return false;
        }
        // jika jumlah product di database tidak sama dengan product yang dikirim
        // return tidak valid
        if (products.size() != details.size()){
            return false;
        }
        // return valid, jika jumlah stock lebih dari 0
        for (ProductEntity product: products){
            var detailModel = details.stream()
                    .filter(detail -> detail.getProductId() == product.getId())
                    .findFirst().orElse(null);
            // Jika detail modelnya nul
            if (detailModel == null){
                return false;
            }
            // Jumlah stock kurang dari jumlah yang di beli
            if (product.getStock() < detailModel.getQuantity()){
                return false;
            }
        }
        return true;
    }

    private CustomerEntity getCustomer(CustomerModel request) {
        // check customer from database
        var result = customerRepo.findByEmail(request.getEmail()).orElse(null);
        // when customer is not exist on database then create new customer
        if (result == null){
            // set new object customer
            CustomerEntity customer = new CustomerEntity();

            BeanUtils.copyProperties(request, customer);
            try {
                customerRepo.saveAndFlush(customer);
                return customer;
            }catch (Exception sabil){
                log.error("Save customer failed, error: {}",sabil.getMessage());
                return null;
            }
        }
        return result;
    }

    @Override
    public Optional<OrderEntity> update(OrderModel request, Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<OrderEntity> delete(Long id) {
        return Optional.empty();
    }
}
