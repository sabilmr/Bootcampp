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
@Table(name = "tbl_hewan")
public class HewanEntity {
    @Id
    @Column (name = "id")
    private Integer id;

    @Column (name = "hewan_name")
    private String name;

    @Column (name = "hewan_jumlahKaki")
    private Integer jumlahKaki;

    @Column (name = "hewan_makanan")
    private String makanan;

    @Column (name = "hewan_kehidupan")
    private String kehidupan;

    @Column (name = "hewan_jenisKulit")
    private String jenisKulit;

    @Column (name = "hewan_caraBergerak")
    private String caraBergerak;

    @Column (name = "hewan_caraBernafas")
    private String caraBernafas;

    @Column (name = "hewan_berkembangbiak")
    private String berkembangbiak;
}
