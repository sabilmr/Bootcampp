package com.bootcamp.webmvc2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorDto {
    private Integer id;
    private String name;
    private String jenis;
    private String bahanBakar;
    private String platNomor;
    private Integer harga;
}
