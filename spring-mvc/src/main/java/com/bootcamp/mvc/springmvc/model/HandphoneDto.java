package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandphoneDto {
    private Integer id;

    private String code;

    private String nameMerk;

    private String ram;

    private String batrai;

    private String storage;

    private String layar;

    private String warna;

    private String dimensi;

    private String tahunRilis;

    private Integer harga;

    private Integer stock;

}
