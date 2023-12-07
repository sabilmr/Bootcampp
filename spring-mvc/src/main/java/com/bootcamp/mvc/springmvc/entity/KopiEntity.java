package com.bootcamp.mvc.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_kopi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KopiEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "kopi_kode")
    private String kode;
    @Column(name = "nameKopi")
    private String nameKopi;
    @Column(name = "kopi_diperoduksi")
    private String diproduksi;
    @Column(name = "kopi_deskripsi")
    private String deskripsi;
    @Column(name = "kopi_harga")
    private Integer harga;
    @Column(name = "kopi_stock")
    private Integer stock;
}
