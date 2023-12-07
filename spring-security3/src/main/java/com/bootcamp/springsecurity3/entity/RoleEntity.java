package com.bootcamp.springsecurity3.entity;

import lombok.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
    @Id
    @Column(name = "id", length = 42)
    private String id;

    @Column(name = "role_name", length = 65, unique = true)
    private String name;
}
