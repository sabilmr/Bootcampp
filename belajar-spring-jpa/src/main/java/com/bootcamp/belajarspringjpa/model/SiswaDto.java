package com.bootcamp.belajarspringjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiswaDto {

    private Integer id;

    private String name;

    private String tempatKuliah;

    private String jurusan;

    private String usia;

    private String warnaKulit;

    private String tinggiBadan;

    private String jenisKelamin;

    private String alamat;
}
