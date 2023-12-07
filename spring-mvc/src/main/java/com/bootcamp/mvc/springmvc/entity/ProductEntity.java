package com.bootcamp.mvc.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_code",length = 10)
    private String code;

    @Column(name = "product_name",length = 150)
    private String name;

    @Column(name = "product_category",length = 32)
    private String category;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_price")
    private Integer price;

    @Column(name = "product_stock")
    private Integer stock;
}
