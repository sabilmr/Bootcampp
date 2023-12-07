package com.sabillamrayhan.posapi3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {
    private Long id;
    private String code;
    private String name;
}
