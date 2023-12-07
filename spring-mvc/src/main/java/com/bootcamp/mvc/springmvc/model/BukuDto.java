package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BukuDto {
    private Integer id;
    private String judul;
    private String pengarang;
    private String tahunTerbit;
    private Integer jumlahHalaman;
    private String penerbit;
    private Integer harga;
    private Integer stock;
    private String bahasa;
    private String deskripsi;
}
