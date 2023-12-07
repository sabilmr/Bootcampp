package com.sabilla.nortwinddapp.model.response;

import com.sabilla.nortwinddapp.model.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private String id;
    private String name;
    private String desc;

    public CategoryResponse(CategoryEntity category) {
        BeanUtils.copyProperties(category, this);

    }
}
