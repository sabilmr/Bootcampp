package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.MobilEntity;
import com.bootcamp.mvc.springmvc.model.MobilDto;
import com.bootcamp.mvc.springmvc.service.MobilService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mobil")
public class MobilController {
    private final MobilService mobilService;

    public MobilController(MobilService mobilService) {
        this.mobilService = mobilService;
    }
    @GetMapping
    public ModelAndView getAll(){
        ModelAndView view = new ModelAndView("mobil/index");

        String judul = "Mobil";
        view.addObject("datajudul",judul);

        List<MobilEntity> datamobil = mobilService.getAll();
        view.addObject("mobil",datamobil);

        Integer jumlah = datamobil.size();
        view.addObject("jumlah",jumlah);
        return view;
    }
    @GetMapping("add")
    public ModelAndView add(){
        return new ModelAndView("mobil/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute MobilDto request){
        mobilService.save(request);
        return new ModelAndView("redirect:/mobil");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable ("id") Integer id){
        MobilEntity mobilEntity = mobilService.getById(id);
        if (mobilEntity == null){
            return new ModelAndView("redirect:/mobil");
        }
        ModelAndView view = new ModelAndView("mobil/edit");
        view.addObject("mobil",mobilEntity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute MobilDto request){
        mobilService.update(request.getId(), request);
        return new ModelAndView("redirect:/mobil");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute MobilDto request){
        MobilEntity mobilEntity = mobilService.getById(request.getId());
        if (mobilEntity == null){
            return new ModelAndView("redirect:/mobil");
        }
        mobilService.delete(request.getId());
        return new ModelAndView("redirect:/mobil");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id){
        MobilEntity mobilEntity = mobilService.getById(id);
        if(mobilEntity == null){
            return new ModelAndView("redirect:/mobil");
        }
        ModelAndView view = new ModelAndView("mobil/detail");
        view.addObject("mobil",mobilEntity);
        return view;
    }
}
