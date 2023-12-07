package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuruDto {
    private Integer id;
    private String nama;
    private String ttl;
    private String jk;
    private String agama;
    private Integer tb;
    private Integer bb;
    private String bangsa;
    private String email;
    private String alamat;
}
