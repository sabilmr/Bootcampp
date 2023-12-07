package com.bootcamp.mvc.springmvc.entity;

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

    @Column(name = "handphone_code")
    private String code;

    @Column(name = "handphone_name",length = 150)
    private String nameMerk;

    @Column(name = "handphone_ram")
    private String ram;

    @Column(name = "handphone_batrai")
    private String batrai;

    @Column(name = "handphone_storage")
    private String storage;

    @Column(name = "handphone_layar")
    private String layar;

    @Column(name = "handphone_warna")
    private String warna;

    @Column(name = "handphone_dimensi")
    private String dimensi;

    @Column(name = "handphone_tahunRilis")
    private String tahunRilis;

    @Column(name = "handphone_harga")
    private Integer harga;

    @Column(name = "handphone_stock")
    private Integer stock;
}
