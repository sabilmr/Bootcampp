package com.bootcamp.belajarspringjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeptopDto {

    private Integer id;
    private String name;
    private String prosesor;
    private String ram;
    private String memori;
    private String batrai;
    private String sistemOperasi;
    private String layar;
    private String dimensi;
    private String warna;
    private Integer rilis;
    private Integer harga;
}
