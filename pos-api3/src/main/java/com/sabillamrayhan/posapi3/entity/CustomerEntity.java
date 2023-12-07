package com.sabillamrayhan.posapi3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "tbl_customer_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "category_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_customer_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "email", length = 70, unique = true)
    private String email;

    @Column(name = "phone", length = 70, unique = true)
    private String phone;

    @Column(name = "address", length = 100)
    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderEntity> orders = new ArrayList<>();

    public CustomerEntity(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
