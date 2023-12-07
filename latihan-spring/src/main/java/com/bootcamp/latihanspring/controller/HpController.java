package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Hp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HpController {

    @GetMapping("test1")
    public Hp get(){
        Hp data = new Hp();
        return data;
    }

    @GetMapping("hp/{name_hp}/{ram}/{prosesor}/{color}/{price}/{quantity}")
    public Hp getHp(@PathVariable String name_hp,
                    @PathVariable Integer ram,
                    @PathVariable String prosesor,
                    @PathVariable String color,
                    @PathVariable Integer price,
                    @PathVariable Integer quantity){
        Hp data = new Hp();
        data.setName_hp(name_hp);
        data.setRam(ram);
        data.setProsesor(prosesor);
        data.setColor(color);
        data.setPrice(price);
        data.setQuantity(quantity);

        return data;
    }
}
