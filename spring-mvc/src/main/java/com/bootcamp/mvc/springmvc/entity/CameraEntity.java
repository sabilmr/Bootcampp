package com.bootcamp.mvc.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_camera")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CameraEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "camera_kode")
    private String kode;
    @Column(name = "camera_name")
    private String name;
    @Column(name = "camera_merk")
    private String merk;
    @Column(name = "camera_tipe")
    private String tipe;
    @Column(name = "camera_sensor")
    private String sensor;
    @Column(name = "camera_fitur")
    private String fitur;
    @Column(name = "camera_lensa")
    private String lensa;

    @Column(name = "camera_aksesoris")
    private String aksesoris;

    @Column(name = "camera_harga")
    private Integer harga;
}
