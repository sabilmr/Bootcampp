package com.bootcamp.webmvc2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiswaDto {
    private Integer id;
    private String name;
    private String tempatKuliah;
    private String jurusan;
    private String alamat;
}
