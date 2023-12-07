package com.bootcamp.webmvc2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_leptop")
public class LeptopEntity {
    @Id
    private String id;
    private String name;
    private String prosesor;
    private String ram;
    private Integer harga;
}
