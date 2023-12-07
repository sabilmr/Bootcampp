package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CameraDto {
    private Integer id;
    private String kode;
    private String name;
    private String merk;
    private String tipe;
    private String sensor;
    private String fitur;
    private String lensa;
    private String aksesoris;
    private Integer harga;
}
