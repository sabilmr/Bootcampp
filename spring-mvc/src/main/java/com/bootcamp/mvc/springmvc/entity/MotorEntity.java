package com.bootcamp.mvc.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tbl_motor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "motor_kode")
    private String kode;
    @Column(name = "motor_name")
    private String name;
    @Column(name = "motor_merk")
    private String merk;
    @Column(name = "motor_platNomor")
    private String platNomor;
    @Column(name = "motor_bahanBakar")
    private String bahanBakar;
    @Column(name = "motor_cc")
    private String cc;
    @Column(name = "motor_warna")
    private String warna;
    @Column(name = "motor_harga")
    private Integer harga;
    @Column(name = "motor_stock")
    private Integer stock;
}
