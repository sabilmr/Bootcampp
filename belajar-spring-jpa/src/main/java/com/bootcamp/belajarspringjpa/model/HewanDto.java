package com.bootcamp.belajarspringjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HewanDto {
    private Integer id;
    private String name;
    private Integer jumlahKaki;
    private String makanan;
    private String kehidupan;
    private String jenisKulit;
    private String caraBernafas;
    private String caraBergerak;
    private String berkembangbiak;

}
