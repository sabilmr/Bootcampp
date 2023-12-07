package com.sabilla.nortwinddapp.repository;

import com.sabilla.nortwinddapp.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, String> {
}
