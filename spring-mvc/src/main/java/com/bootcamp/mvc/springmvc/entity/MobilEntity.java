package com.bootcamp.mvc.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_mobil")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobilEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "mobil_kode")
    private String kode;
    @Column(name = "mobil_name")
    private String name;
    @Column(name = "mobil_merk")
    private String merk;
    @Column(name = "mobil_platNomor")
    private String platNomor;
    @Column(name = "mobil_bahanBakar")
    private String bahanBakar;
    @Column(name = "mobil_cc")
    private String cc;
    @Column(name = "mobil_warna")
    private String warna;
    @Column(name = "mobil_tipe")
    private String tipe;
    @Column(name = "mobil_harga")
    private Integer harga;
    @Column(name = "mobil_stock")
    private Integer stock;
}
