package com.bootcamp.mvc.springmvc.controller;
import com.bootcamp.mvc.springmvc.entity.BukuEntity;
import com.bootcamp.mvc.springmvc.model.BukuDto;
import com.bootcamp.mvc.springmvc.service.BukuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.PublicKey;
import java.util.List;

@Controller
@RequestMapping("/buku")
public class BukuController {
    private final BukuService bukuService;

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }
    @GetMapping
    public ModelAndView getAll(){
        ModelAndView view = new ModelAndView("buku/index");

        String judul = "Buku";
        view.addObject("datajudul",judul);

        List<BukuEntity> databuku = bukuService.getAll();
        view.addObject("buku",databuku);

        Integer jumlah = databuku.size();
        view.addObject("jumlah",jumlah);
        return view;
    }
    @GetMapping("add")
    public ModelAndView add(){
        return new ModelAndView("buku/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute BukuDto request){
        bukuService.save(request);
        return new ModelAndView("redirect:/buku");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable ("id") Integer id){
        BukuEntity entity = bukuService.getById(id);
        if(entity == null){
            return new ModelAndView("redirect:/buku");
        }
        ModelAndView view = new ModelAndView("buku/edit");
        view.addObject("buku",entity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute BukuDto request){
        bukuService.update(request.getId(), request);
        return new ModelAndView("redirect:/buku");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute BukuDto request){
        BukuEntity entity =bukuService.getById(request.getId());
        if(entity == null){
            return new ModelAndView("redirect:/buku");
        }
        bukuService.delete(request.getId());
        return new ModelAndView("redirect:/buku");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id){
        BukuEntity entity = bukuService.getById(id);
        if(entity == null){
            return new ModelAndView("redirect:/buku");
        }
        ModelAndView view = new ModelAndView("buku/detail");
        view.addObject("buku",entity);
        return view;
    }

}
