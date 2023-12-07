package com.bootcamp.mvc.springmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_guru")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuruEntity {
    @Id
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
