package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.SiswaEntity;
import com.bootcamp.mvc.springmvc.model.SiswaDto;
import com.bootcamp.mvc.springmvc.service.SiswaService;
import org.springframework.boot.Banner;
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
    public ModelAndView getAll() {
        ModelAndView view = new ModelAndView("siswa/index");
        String judul = "Siswa";
        view.addObject("datajudul", judul);

        List<SiswaEntity> datasiswa = siswaService.getAll();
        view.addObject("siswa", datasiswa);

        Integer jumlah = datasiswa.size();
        view.addObject("jumlah", jumlah);
        return view;
    }

    @GetMapping("add")
    public ModelAndView add() {
        return new ModelAndView("siswa/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SiswaDto request) {
        siswaService.save(request);
        return new ModelAndView("redirect:/siswa");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        SiswaEntity siswaEntity = siswaService.getById(id);
        if (siswaEntity == null) {
            return new ModelAndView("redirect:/siswa");
        }
        ModelAndView view = new ModelAndView("siswa/edit");
        view.addObject("siswa", siswaEntity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SiswaDto request) {
        siswaService.update(request.getId(), request);
        return new ModelAndView("redirect:/siswa");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute SiswaDto request) {
        SiswaEntity siswaEntity = siswaService.getById(request.getId());
        if (siswaEntity == null) {
            return new ModelAndView("redirect:/siswa");
        }
        siswaService.delete(request.getId());
        return new ModelAndView("redirect:/siswa");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id){
        SiswaEntity siswaEntity = siswaService.getById(id);
        if(siswaEntity == null){
            return new ModelAndView("redirect:/siswa");
        }
        ModelAndView view = new ModelAndView("siswa/detail");
        view.addObject("siswa",siswaEntity);
        return view;
    }
}