package com.bootcamp.belajarspringjpa.repository;

import com.bootcamp.belajarspringjpa.entity.PelajaranEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelajaranRepo extends JpaRepository<PelajaranEntity,Integer> {
}
