package com.sabilla.nortwinddapp.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LookUpResponse {
    private String id;
    private String groups;
    private String code;
    private String name;
    private String position;
    private Boolean active;
}