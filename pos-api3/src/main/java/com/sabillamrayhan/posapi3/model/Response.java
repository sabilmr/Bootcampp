package com.sabillamrayhan.posapi3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private Integer status;
    private String message;
    private Object data;
}
