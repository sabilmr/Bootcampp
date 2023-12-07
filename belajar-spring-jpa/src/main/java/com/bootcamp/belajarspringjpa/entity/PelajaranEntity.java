package com.bootcamp.belajarspringjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_pelajaran")
public class PelajaranEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "pelajaran_hari")
    private String hari;

    @Column(name = "pelajaran_mataPelajaran")
    private String mataPelajaran;

    @Column(name = "pelajaran_guru")
    private String guru;

    @Column(name = "pelajaran_jam")
    private String jam;


}
