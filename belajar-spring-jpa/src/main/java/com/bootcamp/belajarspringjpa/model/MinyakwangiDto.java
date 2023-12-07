package com.bootcamp.belajarspringjpa.model;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinyakwangiDto {
    private Integer id;
    private String nameMerk;
    private String rasa;
    private String warna;
    private String description;
    private Integer harga;
    private Integer jumlah;
}
