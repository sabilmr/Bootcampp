package com.bootcamp.mvc.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_buku")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BukuEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "buku_judul")
    private String judul;
    @Column(name = "buku_pengarang")
    private String pengarang;
    @Column(name = "buku_tahunTerbit")
    private String tahunTerbit;
    @Column(name = "buku_jumlahHalaman")
    private Integer jumlahHalaman;
    @Column(name = "buku_penerbit")
    private String penerbit;
    @Column(name = "buku_harga")
    private Integer harga;
    @Column(name = "buku_stock")
    private Integer stock;
    @Column(name = "buku_bahasa")
    private String bahasa;
    @Column(name = "buku_deskripsi")
    private String deskripsi;
}
