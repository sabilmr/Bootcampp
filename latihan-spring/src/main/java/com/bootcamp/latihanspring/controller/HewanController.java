package com.bootcamp.latihanspring.controller;

import com.bootcamp.latihanspring.model.Hewan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HewanController {

    @GetMapping("3")
    public Hewan get3(){
        Hewan data = new Hewan();
        return data;

    }

    @GetMapping("hewan/{nameHewan}/{kakiHewan}/{makananHewan}/{berkembangbiak}/{kehidupanHewan}")
    public Hewan getHewan(@PathVariable String nameHewan,
                          @PathVariable int kakiHewan,
                          @PathVariable String makananHewan,
                          @PathVariable String berkembangbiak,
                          @PathVariable String kehidupanHewan){
        Hewan data = new Hewan();
        data.setNameHewan(nameHewan);
        data.setKakiHewan(kakiHewan);
        data.setMakananHewan(makananHewan);
        data.setBerkembangbiak(berkembangbiak);
        data.setKehidupanHewan(kehidupanHewan);

        return data;
    }
}
