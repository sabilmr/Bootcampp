package com.bootcamp.webmvc2.controller;

import com.bootcamp.webmvc2.entity.MotorEntity;
import com.bootcamp.webmvc2.entity.SepedaEntity;
import com.bootcamp.webmvc2.model.SepedaDto;
import com.bootcamp.webmvc2.service.SepedaService;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sepeda")
public class SepedaController {
    private final SepedaService sepedaService;

    public SepedaController(SepedaService sepedaService) {
        this.sepedaService = sepedaService;
    }
    @GetMapping
    public ModelAndView index(){
         ModelAndView view = new ModelAndView("sepeda/index");

         String judul = "Sepeda";
         view.addObject("dataJudul",judul);

         List<SepedaEntity> datasepeda = sepedaService.getAll();
         view.addObject("listSepeda",datasepeda);

         Integer jumlah = datasepeda.size();
         view.addObject("jumlah",jumlah);
         return view;
    }
    @GetMapping("add")
    public ModelAndView add(){
        return new ModelAndView("sepeda/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SepedaDto request){
        sepedaService.save(request);
        return new ModelAndView("redirect:/sepeda");
    }

}
