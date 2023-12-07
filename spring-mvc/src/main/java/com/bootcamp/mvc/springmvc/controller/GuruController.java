package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.GuruEntity;
import com.bootcamp.mvc.springmvc.model.GuruDto;
import com.bootcamp.mvc.springmvc.service.GuruService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/guru")
public class GuruController {
    private final GuruService guruService;

    public GuruController(GuruService guruService) {
        this.guruService = guruService;
    }
    @GetMapping
    public ModelAndView getAll(){
        ModelAndView view = new ModelAndView("guru/index");
        String judul = "GURU";
        view.addObject("datajudul",judul);

        List<GuruEntity> dataguru = guruService.getAll();
        view.addObject("guru",dataguru);

        Integer jumlah = dataguru.size();
        view.addObject("jumlah",jumlah);
        return view;
    }
    @GetMapping("add")
    public ModelAndView add(){
        return new ModelAndView("guru/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute GuruDto request){
        guruService.save(request);
        return new ModelAndView("redirect:/guru");
    }
}
