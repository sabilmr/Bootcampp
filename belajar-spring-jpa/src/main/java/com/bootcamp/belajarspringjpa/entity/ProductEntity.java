package com.bootcamp.belajarspringjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class ProductEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "product_name",length = 150)
    private String name;

    @Column(name = "pruduct_description")
    private String description;

    @Column(name = "product_price")
    private int price;

    @Column(name = "product_quantity")
    private int quantity;
}
