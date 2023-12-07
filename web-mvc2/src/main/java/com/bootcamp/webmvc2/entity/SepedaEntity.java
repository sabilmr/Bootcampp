package com.bootcamp.webmvc2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_sepeda")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SepedaEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "kode")
    private String kode;
    @Column(name = "merk")
    private String merk;
    @Column(name = "platNomor")
    private String platNomor;
    @Column(name = "bahanBakar")
    private String bahanBakar;
    @Column(name = "cc")
    private String cc;
    @Column(name = "warna")
    private String warna;
    @Column(name = "harga")
    private Integer harga;
    @Column(name = "stock")
    private Integer stock;
}
