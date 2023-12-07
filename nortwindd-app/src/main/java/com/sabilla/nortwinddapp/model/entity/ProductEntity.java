package com.sabilla.nortwinddapp.model.entity;

import com.sabilla.nortwinddapp.model.response.ProductResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class ProductEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity_per_unit")
    private Double quantityPerUnit;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "stock")
    private Double stock;

    @Column(name = "on_order")
    private String onOrder;

    @Column(name = "reorder_level")
    private Double reorderLevel;

    @Column(name = "discontinued")
    private String discontinued;

    @Column(name = "category_id", length = 36)
    private String categoryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;

    @Column(name = "supplier_id", length = 36)
    private String supplierId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SupplierEntity supplier;

    public ProductEntity(ProductResponse response) {
        BeanUtils.copyProperties(response, this);
        this.id = UUID.randomUUID().toString();
    }
}