package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Handsad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HandsadController {
    @GetMapping("hand")
    public Handsad getHand(){
        Handsad data = new Handsad();
        return data;
    }
    @GetMapping("handsad/{nameMerk}/{color}/{description}/{price}/{quantity}")
    public Handsad getHandsad(@PathVariable String nameMerk,
                              @PathVariable String color,
                              @PathVariable String description,
                              @PathVariable int price,
                              @PathVariable int quantity){
        Handsad data = new Handsad();
        data.setNameMerk(nameMerk);
        data.setColor(color);
        data.setDescription(description);
        data.setPrice(price);
        data.setQuantity(quantity);

        return data;
    }
}
