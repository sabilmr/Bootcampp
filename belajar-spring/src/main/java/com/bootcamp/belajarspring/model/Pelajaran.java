package com.bootcamp.belajarspring.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Pelajaran {
    private String hari;
    private String pelajaran;
    private String guru;
    private String jam;


    public Pelajaran() {
    }

    public Pelajaran(String hari, String pelajaran, String guru, String jam) {
        this.hari = hari;
        this.pelajaran = pelajaran;
        this.guru = guru;
        this.jam = jam;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getPelajaran() {
        return pelajaran;
    }

    public void setPelajaran(String pelajaran) {
        this.pelajaran = pelajaran;
    }

    public String getGuru() {
        return guru;
    }

    public void setGuru(String guru) {
        this.guru = guru;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
}
