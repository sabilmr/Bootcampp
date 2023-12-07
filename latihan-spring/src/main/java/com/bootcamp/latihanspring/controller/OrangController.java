package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Orang;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OrangController {

    @GetMapping("ping")
    public String Ping(){
        return "pong";
    }
    @GetMapping("orang/{id}")
    public Orang getOrang(@PathVariable int id){
        Orang data = new Orang();
        data.setId(id);
        return data;
    }
    @GetMapping("orang/{id}/{name}/{age}/{gender}/{addres}")
    public Orang getOrang(@PathVariable int id,
                          @PathVariable String name,
                          @PathVariable String age,
                          @PathVariable String gender,
                          @PathVariable String addres){
        Orang data = new Orang();
        data.setId(id);
        data.setName(name);
        data.setAge(age);
        data.setGender(gender);
        data.setAddres(addres);

        return data;
    }
    @GetMapping("orang1/{id}/{name}/{age}/{gender}/{addres}")
    public Orang getOrang1(@PathVariable int id,
                          @PathVariable String name,
                          @PathVariable String age,
                          @PathVariable String gender,
                          @PathVariable String addres){
        Orang data = new Orang();
        data.setId(id);
        data.setName(name);
        data.setAge(age);
        data.setGender(gender);
        data.setAddres(addres);

        return data;
    }
}
