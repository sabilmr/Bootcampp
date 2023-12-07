package com.bootcsmp.securitydemo.entity;

import com.bootcsmp.securitydemo.dto.CartItemDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tbl_cart_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemEntity {
    @Id
    @Column(name = "id", length = 39)
    private String id;

    @Column(name = "cart_id", length = 39, nullable = false)
    private String cartId;

    @Column(name = "product_id", length = 39, nullable = false)
    private String productId;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "sub_total")
    private Double subTotal;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @JsonBackReference
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    @JsonBackReference
    private CartEntity cart;

    public CartItemEntity(CartItemDto itemDto,String cartId) {
        this.id = UUID.randomUUID().toString();
        this.cartId = cartId;
        this.productId = itemDto.getProductId();
        this.quantity = itemDto.getQuantity();
        this.price = itemDto.getPrice();
        this.subTotal = itemDto.getQuantity() * getPrice();
    }
}
