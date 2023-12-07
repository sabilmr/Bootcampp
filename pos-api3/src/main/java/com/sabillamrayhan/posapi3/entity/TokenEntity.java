package com.sabillamrayhan.posapi3.entity;

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
@Table(name = "tbl_token")
public class TokenEntity {
    @Id
    @TableGenerator(name = "tbl_token_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName = "sequence_value",
            pkColumnValue = "token_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_token_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "token", unique = true, length = 1120)
    private String token;

    @Column(name = "token_type", length = 30)
    private String tokenType;

    @Column(name = "revoked")
    private boolean revoked;

    @Column(name = "expired")
    private boolean expired;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public UserEntity user;
}
