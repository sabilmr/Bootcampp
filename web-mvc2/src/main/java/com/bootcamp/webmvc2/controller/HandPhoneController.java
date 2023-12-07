package com.bootcamp.webmvc2.controller;

import com.bootcamp.webmvc2.entity.HandphoneEntity;
import com.bootcamp.webmvc2.model.HandphoneDto;
import com.bootcamp.webmvc2.service.HandphoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/handphone")
public class HandPhoneController {
    private final HandphoneService handphoneService;

    public HandPhoneController(HandphoneService handphoneService) {
        this.handphoneService = handphoneService;
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("handphone/index");

        String judul = "Handphone";
        view.addObject("datajudul",judul);

        List<HandphoneEntity> datahandphone = handphoneService.getAll();
        view.addObject("listHandphone",datahandphone);

        Integer jumlah = datahandphone.size();
        view.addObject("jumlah",jumlah);
        return view;
    }
    @GetMapping("add")
    public ModelAndView add(){
        return new ModelAndView("handphone/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute HandphoneDto request){
        handphoneService.save(request);
        return new ModelAndView("redirect:/handphone");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable ("id") Integer id){
        HandphoneEntity entity = handphoneService.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/handphone");
        }
        ModelAndView view = new ModelAndView("handphone/edit");
        view.addObject("handphone",entity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute HandphoneDto request){
        handphoneService.update(request.getId(), request);
        return new ModelAndView("redirect:/handphone");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute HandphoneDto request){
        HandphoneEntity entity = handphoneService.getById(request.getId());
        if (entity == null){
            return new ModelAndView("redirect:/handphone");
        }
        handphoneService.delete(request.getId());
        return new ModelAndView("redirect:/handphone");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id){
        HandphoneEntity entity = handphoneService.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/handphone");
        }
        ModelAndView view = new ModelAndView("handphone/detail");
        view.addObject("handphone",entity);
        return view;
    }
}
