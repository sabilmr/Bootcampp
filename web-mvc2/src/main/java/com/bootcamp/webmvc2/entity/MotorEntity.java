package com.bootcamp.webmvc2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_motor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "jenis")
    private String jenis;

    @Column(name = "bahanBakar")
    private String bahanBakar;

    @Column(name = "platNomor")
    private String platNomor;

    @Column(name = "harga")
    private Integer harga;
}
