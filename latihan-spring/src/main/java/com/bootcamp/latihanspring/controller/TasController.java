package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Tas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TasController {

    @GetMapping("as")
    public Tas getAs(){
        Tas data = new Tas();
        return data;
    }
    @GetMapping("tas/{nameMerk}/{warna}/{description}/{price}/{quantity}")
    public Tas getTas(@PathVariable String nameMerk,
                      @PathVariable String warna,
                      @PathVariable String description,
                      @PathVariable int price,
                      @PathVariable int quantity){
        Tas data = new Tas();
        data.setNameMerk(nameMerk);
        data.setWarna(warna);
        data.setDescription(description);
        data.setPrice(price);
        data.setQuantity(quantity);

        return data;
    }
}
