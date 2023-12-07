package com.bootcamp.mvc.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_leptop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeptopEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "leptop_kode")
    private String kode;

    @Column(name = "leptop_name")
    private String name;

    @Column(name = "leptop_ram")
    private String ram;

    @Column(name = "leptop_prosesor")
    private String prosesor;

    @Column(name = "leptop_storage")
    private String storage;

    @Column(name = "leptop_os")
    private String os;

    @Column(name = "leptop_layar")
    private String layar;

    @Column(name = "leptop_dimensi")
    private String dimensi;

    @Column(name = "leptop_warna")
    private String warna;

    @Column(name = "leptop_tahunRilis")
    private String tahunRilis;

    @Column(name = "leptop_harga")
    private Integer harga;

    @Column(name = "leptop_stock")
    private Integer stock;
}
