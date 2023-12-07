package com.sabillamrayhan.springjpa4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Column(name = "ACCOUNT_NO", unique = true)
    private Long accountNo;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String name;

    @Column(name = "CUSTOMER_EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "CUSTOMER_ADDRESS")
    private String address;
}
