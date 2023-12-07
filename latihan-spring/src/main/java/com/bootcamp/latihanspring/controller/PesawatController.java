package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Pesawat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PesawatController {

    @GetMapping("get")
    public Pesawat Get(){
        Pesawat data = new Pesawat();
        return data;
    }
    @GetMapping("pesawat/{namePesawat}/{arahPenerbangan}/{description}/{jumlahPenumpang}/{hargatiket}")
    public Pesawat getPesawat(@PathVariable String namePesawat,
                              @PathVariable String arahPenerbangan,
                              @PathVariable String description,
                              @PathVariable int jumlahPenumpang,
                              @PathVariable int hargatiket){
        Pesawat data = new Pesawat();
        data.setNamePesawat(namePesawat);
        data.setArahPenerbangan(arahPenerbangan);
        data.setDescription(description);
        data.setJumlahPenumpang(jumlahPenumpang);
        data.setHargaTiket(hargatiket);

        return data;
    }
}
