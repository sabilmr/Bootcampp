package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Leptop;
import jdk.jfr.DataAmount;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LeptopController {

    @GetMapping("top")
    public Leptop getTop(){
        Leptop data = new Leptop();
        return data;
    }

    @GetMapping("leptop/{nameLeptop}/{prosesor}/{ram}/{penyimpanan}/{batrai}/{warna}/{harga}")
    public Leptop getLeptop(@PathVariable String nameLeptop,
                            @PathVariable String prosesor,
                            @PathVariable String ram,
                            @PathVariable String penyimpanan,
                            @PathVariable String batrai,
                            @PathVariable String warna,
                            @PathVariable int harga){
        Leptop data = new Leptop();
        data.setNameLeptop(nameLeptop);
        data.setProsesor(prosesor);
        data.setRam(ram);
        data.setPenyimpanan(penyimpanan);
        data.setBatrai(batrai);
        data.setWarna(warna);
        data.setHarga(harga);

        return data;
    }
}
