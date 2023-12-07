package com.bootcsmp.securitydemo.entity;

import com.bootcsmp.securitydemo.dto.CartDto;
import com.bootcsmp.securitydemo.dto.CartItemDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.context.support.UiApplicationContextUtils;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tbl_cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartEntity {
    @Id
    @Column(name = "id", length = 39)
    private String id;

    @Column(name = "customer_name", length = 110)
    private String customerName;

    @Column(name = "invoice_no", length = 20)
    private String invoiceNo;

    @Column(name = "total")
    private Double total;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "cart",
    cascade = CascadeType.ALL,
    orphanRemoval = true)

    @JsonManagedReference
    private List<CartItemEntity> cartItems = new ArrayList<>();

    public void addCartItem(CartItemEntity itemEntity){
        this.cartItems.add(itemEntity);
        itemEntity.setCart(this);
    }
    public void removeCartItem(CartItemEntity itemEntity){
        this.cartItems.remove(itemEntity);
        itemEntity.setCart(null);
    }
    public CartEntity(CartDto cartDto){
        id = UUID.randomUUID().toString();
        customerName = cartDto.getCustomerName();
        invoiceNo = cartDto.getInvoiceNo();
        createdAt = LocalDateTime.now();

        Double vTotal = 0.0;
        for (CartItemDto itemDto: cartDto.getCartItems()){
            CartItemEntity itemEntity = new CartItemEntity(itemDto, this.id);
            addCartItem(itemEntity);
            vTotal += itemEntity.getSubTotal();
        }
        total = vTotal;

    }

}
