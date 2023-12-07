package com.bootcamp.webmvc2.controller;

import com.bootcamp.webmvc2.entity.SiswaEntity;
import com.bootcamp.webmvc2.model.SiswaDto;
import com.bootcamp.webmvc2.service.SiswaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/siswa")
public class SiswaController {
    private final SiswaService siswaService;

    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("siswa/index");

        String judul = "Siswa";
        view.addObject("datajudul",judul);

        List<SiswaEntity> datasiswa = siswaService.getAll();
        view.addObject("siswaList",datasiswa);

        Integer jumlah = datasiswa.size();
        view.addObject("jumlah",jumlah);
        return view;
    }
    @GetMapping("add")
    public ModelAndView add(){
        return new ModelAndView("siswa/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SiswaDto request){
        siswaService.save(request);
        return new ModelAndView("redirect:/siswa");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable ("id") Integer id){
        SiswaEntity entity = siswaService.getById(id);
        if(entity == null){
            return new ModelAndView("redirect:/siswa");
        }
        ModelAndView view = new ModelAndView("siswa/edit");
        view.addObject("siswa",entity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SiswaDto request){
        siswaService.update(request.getId(), request);
        return new ModelAndView("redirect:/siswa");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute SiswaDto request){
        SiswaEntity entity = siswaService.getById(request.getId());
        if(entity == null){
            return new ModelAndView("redirect:/siswa");
        }
        siswaService.delete(request.getId());
        return new ModelAndView("redirect:/siswa");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id){
        SiswaEntity entity = siswaService.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/siswa");
        }
        ModelAndView view = new ModelAndView("siswa/detail");
        view.addObject("siswa",entity);
        return view;
    }

}
