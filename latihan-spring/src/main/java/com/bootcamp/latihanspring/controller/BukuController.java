package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Buku;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BukuController {

    @GetMapping("book")
    public Buku getBook(){
        Buku data = new Buku();
        return data;
    }
    @GetMapping("buku/{nameBuku}/{halamanBuku}/{description}/{harga}/{jumlah}")
    public Buku getBuku(@PathVariable String nameBuku,
                        @PathVariable int halamanBuku,
                        @PathVariable String description,
                        @PathVariable int harga,
                        @PathVariable int jumlah){
        Buku data = new Buku();
        data.setNameBuku(nameBuku);
        data.setHalamanBuku(halamanBuku);
        data.setDescription(description);
        data.setHerga(harga);
        data.setJumlah(jumlah);

        return data;
    }
}
