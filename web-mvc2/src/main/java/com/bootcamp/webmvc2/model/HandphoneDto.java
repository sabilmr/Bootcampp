package com.bootcamp.webmvc2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandphoneDto {
    private Integer id;
    private String code;
    private String name;
    private String ram;
    private String batrai;
    private Integer harga;
}
