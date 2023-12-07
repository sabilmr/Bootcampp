package com.bootcamp.mvc.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_siswa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiswaEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "siswa_name")
    private String name;
    @Column(name = "siswa_usia")
    private String usia;
    @Column(name = "siswa_tempatKuliah")
    private String tempatKuliah;
    @Column(name = "siswa_jurusan")
    private String jurusan;
    @Column(name = "siswa_tinggiBadan")
    private String tinggiBadan;
    @Column(name = "siswa_jenisKulit")
    private String jenisKulit;
    @Column(name = "siswa_jenisKelamin")
    private String jenisKelamin;
    @Column(name = "siswa_alamat")
    private String alamat;

}
