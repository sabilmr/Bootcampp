package com.bootcamp.belajarspringjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobilDto {
    private Integer id;
    private String namaKendaraan;
    private String jenisKendaraan;
    private Integer roda;
    private String platNomer;
    private String warna;
    private String bahanBakar;
    private Integer cc;
    private Integer harga;

}
