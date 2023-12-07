package com.sabillamrayhan.springjpa4.repository;

import com.sabillamrayhan.springjpa4.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {
}
