package com.sabillamrayhan.posapi2.model;

import com.sabillamrayhan.posapi2.entity.OrderDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {
    private Long productId;
    private Double price;
    private Double quantity;

    public OrderDetailModel(OrderDetailEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}
