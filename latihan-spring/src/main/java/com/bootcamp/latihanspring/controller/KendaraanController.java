package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Kendaraan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class KendaraanController {

    @GetMapping("test")
    public Kendaraan get(){
        Kendaraan kendaraan = new Kendaraan();
        return kendaraan;
    }

    @GetMapping("kendaraan/{nama_k}/{jenis_k}/{roda}/{plat_nomer}/{warna}/{bahan_bakar}/{cc}/{harga}")
    public Kendaraan getKendaraan(@PathVariable String nama_k,
                                  @PathVariable String jenis_k,
                                  @PathVariable Integer roda,
                                  @PathVariable String plat_nomer,
                                  @PathVariable String warna,
                                  @PathVariable String bahan_bakar,
                                  @PathVariable Integer cc,
                                  @PathVariable Integer harga){
        Kendaraan data = new Kendaraan();
        data.setNama_k(nama_k);
        data.setJenis_k(jenis_k);
        data.setRoda(roda);
        data.setPlat_nomer(plat_nomer);
        data.setWarna(warna);
        data.setBahan_bakar(bahan_bakar);
        data.setCc(cc);
        data.setHarga(harga);

        return data;
    }
    @GetMapping("kendaraan1/{nama_k}/{jenis_k}/{roda}/{plat_nomer}/{warna}/{bahan_bakar}/{cc}/{harga}")
    public Kendaraan getKendaraan1(@PathVariable String nama_k,
                                   @PathVariable String jenis_k,
                                   @PathVariable Integer roda,
                                   @PathVariable String plat_nomer,
                                   @PathVariable String warna,
                                   @PathVariable String bahan_bakar,
                                   @PathVariable Integer cc,
                                   @PathVariable Integer harga){
        Kendaraan data = new Kendaraan();
        data.setNama_k(nama_k);
        data.setJenis_k(jenis_k);
        data.setRoda(roda);
        data.setPlat_nomer(plat_nomer);
        data.setWarna(warna);
        data.setBahan_bakar(bahan_bakar);
        data.setCc(cc);
        data.setHarga(harga);

        return data;
    }
}
