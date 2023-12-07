package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Kopi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class KopiController {

    @GetMapping("coffe")
    public Kopi getCoffe(){
        Kopi data = new Kopi();
        return data;
    }
    @GetMapping("kopi/{nameKopi}/{diproduksi}/{description}/{harga}/{jumlah}")
    public Kopi getKopi(@PathVariable String nameKopi,
                        @PathVariable String diproduksi,
                        @PathVariable String description,
                        @PathVariable int harga,
                        @PathVariable int jumlah){
        Kopi data = new Kopi();
        data.setNameKopi(nameKopi);
        data.setDiproduksi(diproduksi);
        data.setDescription(description);
        data.setHarga(harga);
        data.setJumlah(jumlah);

        return data;
    }

}
