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
@Table(name = "tbl_sepeda")
public class SepedaEntity {
    @Id
    @Column (name = "id")
    private Integer id;

    @Column (name = "name_Kendaraan",length = 150)
    private String nameKendaraan;

    @Column (name = "jenis_Kendaraan")
    private String jenisKendaraan;

    @Column (name = "roda")
    private Integer roda;

    @Column (name = "ukuran_roda_depan")
    private String ukuranRodaDepan;

    @Column (name = "ukuran_roda_belakang")
    private String ukuranRodaBelakang;

    @Column (name = "plat_nomor")
    private String platNomor;

    @Column (name = "bahan_bakar")
    private String bahanBakar;

    @Column (name = "cc")
    private String cc;

    @Column (name = "tipe_mesin")
    private String tipeMesin;

    @Column (name = "daya_maksimum")
    private String dayaMaksimum;

    @Column (name = "torsi_maksimum")
    private String torsiMaksimum;

    @Column (name = "harga")
    private Integer harga;

}
