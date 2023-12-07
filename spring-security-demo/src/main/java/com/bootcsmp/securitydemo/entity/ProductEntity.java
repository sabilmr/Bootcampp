package com.bootcsmp.securitydemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @Column(name = "id", length = 40)
    private String id;

    @Column(name = "product_code", length = 20)
    private String code;

    @Column(name = "product_name", length = 20)
    private String name;

    @Column(name = "product_price")
    private Double price;

    @Column(name = "product_stock")
    private Double stock;


}
