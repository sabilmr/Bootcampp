package com.bootcamp.belajarspringjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PelajaranDto {
    private Integer id;
    private String hari;
    private String mataPelajaran;
    private String guru;
    private String jam;
}
