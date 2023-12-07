package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Siswa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SiswaController {

    @GetMapping("sis")
    public Siswa getSis(){
        Siswa data = new Siswa();
        return data;
    }
    @GetMapping("siswa/{id}/{name}/{age}/{major}/{height}/{sekinColor}/{gender}/{addres}")
    public Siswa getSiswa(@PathVariable int id,
                          @PathVariable String name,
                          @PathVariable String age,
                          @PathVariable String major,
                          @PathVariable String height,
                          @PathVariable String sekinColor,
                          @PathVariable String gender,
                          @PathVariable String addres){
        Siswa data = new Siswa();
        data.setId(id);
        data.setName(name);
        data.setAge(age);
        data.setMajor(major);
        data.setHeight(height);
        data.setSekinColor(sekinColor);
        data.setGender(gender);
        data.setAddres(addres);

        return data;
    }
}
