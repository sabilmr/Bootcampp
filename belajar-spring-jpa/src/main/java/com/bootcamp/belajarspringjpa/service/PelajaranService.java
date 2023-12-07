package com.bootcamp.belajarspringjpa.service;

import com.bootcamp.belajarspringjpa.entity.PelajaranEntity;
import com.bootcamp.belajarspringjpa.model.PelajaranDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PelajaranService {
    List<PelajaranEntity> getAll();
    PelajaranEntity getById(Integer id);
    PelajaranEntity save(PelajaranDto request);
    PelajaranEntity delete(Integer id);
    PelajaranEntity update(Integer id, PelajaranDto request);
}
