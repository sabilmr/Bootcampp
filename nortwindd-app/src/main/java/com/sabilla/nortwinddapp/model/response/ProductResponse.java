package com.sabilla.nortwinddapp.model.response;

import com.sabilla.nortwinddapp.model.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private Double quantityPerUnit;
    private Double unitPrice;
    private Double stock;
    private String onOrder;
    private Double reorderLevel;
    private String discontinued;

    private String categoryName;

    private String supplierId;
    private String supplierName;

    public ProductResponse(ProductEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getSupplier() != null){
            this.id = entity.getSupplierId();
            this.supplierName = entity.getSupplier().getCompanyName();
        }
    }
}
