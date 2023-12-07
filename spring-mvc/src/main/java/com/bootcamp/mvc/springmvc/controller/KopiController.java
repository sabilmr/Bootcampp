package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.KopiEntity;
import com.bootcamp.mvc.springmvc.model.KopiDto;
import com.bootcamp.mvc.springmvc.service.KopiService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/kopi")
public class KopiController {
    private final KopiService kopiService;

    public KopiController(KopiService kopiService) {
        this.kopiService = kopiService;
    }
    @GetMapping
    public ModelAndView getAll(){
        ModelAndView view = new ModelAndView("kopi/index");

        String judul = "Kopi";
        view.addObject("datajudul",judul);

        List<KopiEntity> datakopi = kopiService.getAll();
        view.addObject("kopi",datakopi);

        Integer jumlah = datakopi.size();
        view.addObject("jumlah",jumlah);
        return view;
    }
    @GetMapping("add")
    public ModelAndView add(){
        return new ModelAndView("kopi/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute KopiDto request){
        kopiService.save(request);
        return new ModelAndView("redirect:/kopi");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit (@PathVariable ("id") Integer id){
        KopiEntity kopiEntity = kopiService.getById(id);
        if(kopiEntity == null){
            return new ModelAndView("redirect:/kopi");
        }
        ModelAndView view = new ModelAndView("kopi/edit");
        view.addObject("kopi",kopiEntity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute KopiDto request){
        kopiService.update(request.getId(), request);
        return new ModelAndView("redirect:/kopi");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute KopiDto request){
        KopiEntity kopiEntity = kopiService.getById(request.getId());
        if(kopiEntity == null){
            return new ModelAndView("redirect:/kopi");
        }
        kopiService.delete(request.getId());
        return new ModelAndView("redirect:/kopi");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id){
        KopiEntity kopiEntity = kopiService.getById(id);
        if (kopiEntity == null){
            return new ModelAndView("redirect:/kopi");
        }
        ModelAndView view = new ModelAndView("kopi/detail");
        view.addObject("kopi",kopiEntity);
        return view;
    }
}
