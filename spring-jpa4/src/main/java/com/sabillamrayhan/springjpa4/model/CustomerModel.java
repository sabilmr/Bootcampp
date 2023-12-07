package com.sabillamrayhan.springjpa4.model;

import com.sabillamrayhan.springjpa4.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    private Long id;
    private Long accountNo;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    public CustomerModel(CustomerEntity entity){
        BeanUtils.copyProperties(entity,this);
    }
}
