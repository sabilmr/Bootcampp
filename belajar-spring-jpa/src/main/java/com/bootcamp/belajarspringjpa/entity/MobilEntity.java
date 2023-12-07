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
@Table(name = "tbl_mobil")
public class MobilEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column (name = "mobil_nameKendaraan",length = 150)
    private String nameKendaraan;

    @Column (name = "Mobil_jenisKendaraan")
    private String jenisKendaran;

    @Column (name = "Mobil_roda")
    private Integer roda;

    @Column (name = "Mobil_platNomer")
    private String platNomer;

    @Column (name = "Mobil_warna")
    private String warna;

    @Column (name = "mobil_bahanBakar")
    private String bahanBakar;

    @Column (name = "mobil_cc")
    private Integer cc;

    @Column (name = "mobil_harga")
    private Integer harga;

}
