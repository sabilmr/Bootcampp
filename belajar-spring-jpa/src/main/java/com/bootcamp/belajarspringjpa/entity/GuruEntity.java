package com.bootcamp.belajarspringjpa.entity;

import jakarta.persistence.Column;
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
@Table(name = "tbl_guru")
public class GuruEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "guru_name")
    private String name;

    @Column(name = "guru_tempatMengajar")
    private String tempatMengajar;

    @Column(name = "guru_usia")
    private String usia;

    @Column(name = "guru_tinggiBadan")
    private String tinggiBadan;

    @Column(name = "guru_warnaKulit")
    private String warnaKulit;

    @Column(name = "guru_jenisKelamin")
    private String jenisKelamin;

    @Column(name = "guru_alamat")
    private String alamat;


}
