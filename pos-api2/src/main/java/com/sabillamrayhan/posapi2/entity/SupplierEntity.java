package com.sabillamrayhan.posapi2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_supplier")
public class SupplierEntity {
    @Id
    @TableGenerator(name = "tbl_supplier_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "category_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_supplier_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "email", length = 70)
    private String email;

    @Column(name = "phone", length = 70)
    private String phone;

    @Column(name = "address", length = 120)
    private String address;

    @Column(name = "homepage", length = 120)
    private String homepage;

    public SupplierEntity(String name, String email, String phone, String address, String homepage){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.homepage = homepage;
    }
}
