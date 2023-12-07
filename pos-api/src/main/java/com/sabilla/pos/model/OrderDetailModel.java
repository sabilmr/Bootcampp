package com.sabilla.pos.model;

import com.sabilla.pos.entity.OrderDetailEntity;
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

    public OrderDetailModel(OrderDetailEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
