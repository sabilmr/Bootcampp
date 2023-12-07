package com.bootcamp.webmvc2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_handphone")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandphoneEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "ram")
    private String ram;

    @Column(name = "batrai")
    private String batrai;

    @Column(name = "harga")
    private Integer harga;
}
