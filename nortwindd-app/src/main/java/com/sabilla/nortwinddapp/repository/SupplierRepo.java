package com.sabilla.nortwinddapp.repository;

import com.sabilla.nortwinddapp.model.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<SupplierEntity, String> {
}
