package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiswaDto {
    private Integer id;
    private String name;
    private String usia;
    private String tempatKuliah;
    private String jurusan;
    private String tinggiBadan;
    private String jenisKulit;
    private String jenisKelamin;
    private String alamat;
}
