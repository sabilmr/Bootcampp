package com.bootcamp.mvc.springmvc.model;

import ch.qos.logback.core.model.INamedModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeptopDto {
    private Integer id;
    private String kode;
    private String name;
    private String ram;
    private String prosesor;
    private String storage;
    private String os;
    private String layar;
    private String dimensi;
    private String warna;
    private String tahunRilis;
    private Integer harga;
    private Integer stock;

}
