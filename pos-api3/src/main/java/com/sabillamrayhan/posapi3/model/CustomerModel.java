package com.sabillamrayhan.posapi3.model;

import com.sabillamrayhan.posapi3.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public CustomerModel(CustomerEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}
