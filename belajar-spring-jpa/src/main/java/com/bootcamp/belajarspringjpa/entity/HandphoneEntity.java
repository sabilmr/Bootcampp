package com.bootcamp.belajarspringjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_hanephone")
public class HandphoneEntity {
    @Id
    @Column (name = "id")
    private Integer id;

    @Column (name = "Hp_nameMerk",length = 150)
    private String nameMerk;

    @Column (name = "Hp_ram")
    private String ram;

    @Column (name = "Hp_batrai")
    private String batrai;

    @Column (name = "Hp_storage")
    private String storage;

    @Column (name = "Hp_layar")
    private String layar;

    @Column (name = "Hp_warna")
    private String warna;

    @Column (name = "Hp_dimensi")
    private String dimensi;

    @Column (name = "Hp_tahunRilis")
    private String tahunRilis;

    @Column (name = "Hp_harga")
    private Integer harga;

}
