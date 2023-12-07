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
@Table(name = "tbl_role")
public class RoleEntity {
    @Id
    @TableGenerator(name = "tbl_role_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "role_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_role_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 35)
    private String name;

    public RoleEntity(String name){
        this.name = name;
    }
}
