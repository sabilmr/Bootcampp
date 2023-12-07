package com.bootcamp.belajarspringjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_leptop")
public class LeptopEntity {

    @Id
    @Column (name = "id")
    private Integer id;

    @Column (name = "leptop_name",length = 150)
    private String name;

    @Column (name = "leptop_prosesor")
    private String prosesor;

    @Column (name = "leptop_ram")
    private String ram;

    @Column (name = "leptop_memori")
    private String memori;

    @Column (name = "leptop_batrai")
    private String batrai;

    @Column (name = "leptop_sistemOperasi")
    private String sistemOperasi;

    @Column (name = "leptop_layar")
    private String layar;

    @Column (name = "leptop_dimensi")
    private String dimensi;

    @Column (name = "leptop_warna")
    private String warna;

    @Column (name = "leptop_rilis")
    private Integer rilis;

    @Column (name = "leptop_harga")
    private Integer harga;

}
