package com.bootcamp.belajarspringjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuruDto {
    private Integer id;
    private String name;
    private String tempatMengajar;
    private String usia;
    private String tinggiBadan;
    private String warnaKulit;
    private String jenisKelamin;
    private String alamat;
}
