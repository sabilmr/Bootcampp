package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Sekolah;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SekolahController {

    @GetMapping("2")
    public Sekolah get2(){
        Sekolah data = new Sekolah();
        return data;
    }
    @GetMapping("sekolah/{id}/{namaSekolah}/{rengkingSekolah}/{lokasiSekolah}")
    public Sekolah getSekolah(@PathVariable int id,
                              @PathVariable String namaSekolah,
                              @PathVariable String rengkingSekolah,
                              @PathVariable String lokasiSekolah){
        Sekolah data = new Sekolah();
        data.setId(id);
        data.setNamaSekolah(namaSekolah);
        data.setRengkingSekolah(rengkingSekolah);
        data.setLokasiSekolah(lokasiSekolah);

        return data;
    }
}
