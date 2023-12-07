package com.bootcamp.belajarspringjpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SepedaDto {

    private Integer id;
    private String nameKendaraan;
    private String jenisKendaraan;
    private Integer roda;
    private String ukuranRodaDepan;
    private String ukuranRodaBelakang;
    private String platNomor;
    private String bahanBakar;
    private String cc;
    private String tipeMesin;
    private String dayaMaksimum;
    private String torsiMaksimum;
    private Integer harga;

}
