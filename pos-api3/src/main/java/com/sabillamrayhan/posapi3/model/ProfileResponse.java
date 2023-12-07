package com.sabillamrayhan.posapi3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;
}
