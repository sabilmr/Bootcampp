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
@Table(name = "tbl_siswa")
public class SiswaEntity {

    @Id
    @Column (name = "id")
    private Integer id;

    @Column (name = "name",length = 150)
    private String name;

    @Column (name = "tempatKuliah")
    private String tempatKuliah;

    @Column (name = "jurusan")
    private String jurusan;

    @Column (name = "usia")
    private String usia;

    @Column (name = "warnaKulit")
    private String warnaKulit;

    @Column (name = "tinggiBadan")
    private String tinggiBadan;

    @Column (name = "jenisKelamin")
    private String jenisKelamin;

    @Column (name = "alamat")
    private String alamat;


}
