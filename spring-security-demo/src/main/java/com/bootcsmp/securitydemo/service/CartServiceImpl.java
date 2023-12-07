package com.bootcsmp.securitydemo.service;

import com.bootcsmp.securitydemo.dto.CartDto;
import com.bootcsmp.securitydemo.dto.CartItemDto;
import com.bootcsmp.securitydemo.entity.CartEntity;
import com.bootcsmp.securitydemo.entity.CartItemEntity;
import com.bootcsmp.securitydemo.repository.CartRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepo cartRepo;
    @Override
    public List<CartEntity> getAll() {
        return cartRepo.findAll();
    }

    @Override
    public Optional<CartEntity> getById(String id) {
        if (id.isEmpty())
            return Optional.empty();

        return cartRepo.findById(id);
    }

    @Override
    public Optional<CartEntity> save(CartDto request) {
        if (request == null)
            return Optional.empty();

        CartEntity cart = new CartEntity();
        cart.setId(UUID.randomUUID().toString());
        cart.setCustomerName(request.getCustomerName());
        cart.setInvoiceNo(request.getInvoiceNo());

        double total = 0.0;
        for (CartItemDto itemDto: request.getCartItems()){
            CartItemEntity itemEntity = new CartItemEntity();
            itemEntity.setId(UUID.randomUUID().toString());
            itemEntity.setCartId(cart.getId());
            itemEntity.setProductId(itemDto.getProductId());
            itemEntity.setQuantity(itemDto.getQuantity());
            itemEntity.setPrice(itemDto.getPrice());
            itemEntity.setSubTotal(itemDto.getQuantity() * itemDto.getPrice());

            cart.addCartItem(itemEntity);

            total = total + itemEntity.getSubTotal();
        }
        cart.setTotal(total);

        cart.setCreatedAt(LocalDateTime.now());

        try {
            cartRepo.save(cart);
            log.info("Save cart success");
            return Optional.of(cart);
        }catch (Exception e){
            log.error("Save cart failed, error : {}",e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public Optional<CartEntity> simpleSave(CartDto request) {
        if (request == null){
            log.info("Request is null");
            return Optional.empty();
        }
        CartEntity cart = new CartEntity(request);
        try {
            cartRepo.save(cart);
            log.info("Save cart success");
            return Optional.of(cart);
        }catch (Exception e){
            log.error("Save cart failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }
}
