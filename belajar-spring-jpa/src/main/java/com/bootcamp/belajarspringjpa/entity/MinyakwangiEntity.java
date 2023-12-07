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
@Table (name = "tbl_minyakwangi")
public class MinyakwangiEntity {
    @Id
    @Column (name = "id")
    private Integer id;

    @Column (name = "minyakwangi_nameMerk")
    private String nameMerk;

    @Column (name = "minyakwangi_rasa")
    private String rasa;

    @Column (name = "minyakwangi_warna")
    private String warna;

    @Column (name = "minyakwangi_description")
    private String description;

    @Column (name = "minyakwangi_harga")
    private Integer harga;

    @Column (name = "minyakwangi_jumlah")
    private Integer jumlah;
}
