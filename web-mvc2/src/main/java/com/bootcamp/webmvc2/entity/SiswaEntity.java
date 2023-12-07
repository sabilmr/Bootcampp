package com.bootcamp.webmvc2.entity;

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
@AllArgsConstructor
@NoArgsConstructor
public class SiswaEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "tempatKuliah")
    private String tempatKuliah;

    @Column(name = "jurusan")
    private String jurusan;

    @Column(name = "alamat")
    private String alamat;
}
