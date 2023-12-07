package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KopiDto {
    private Integer id;
    private String kode;
    private String nameKopi;
    private String diproduksi;
    private String deskripsi;
    private Integer harga;
    private Integer stock;
}
