package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.HandphoneEntity;
import com.bootcamp.mvc.springmvc.model.HandphoneDto;
import com.bootcamp.mvc.springmvc.service.HandphoneService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/handphone")
public class HandphoneController {
    private final HandphoneService handphoneService;

    public HandphoneController(HandphoneService handphoneService) {
        this.handphoneService = handphoneService;
    }
    @GetMapping
    public ModelAndView getAll(){
        ModelAndView view = new ModelAndView("handphone/index");

        String judul = "Handphone";
        view.addObject("datajudul",judul);

        List<HandphoneEntity> dataHandphone = handphoneService.getAll();
        view.addObject("handphone",dataHandphone);

        Integer jumlah = dataHandphone.size();
        view.addObject("jumlah",jumlah);

        return view;
    }
    @GetMapping("add")
    public ModelAndView add(){
        return new ModelAndView("handphone/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute HandphoneDto request){
        this.handphoneService.save(request);
        return new ModelAndView("redirect:/handphone");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable ("id")Integer id){
        HandphoneEntity result = handphoneService.getById(id);
        if(result == null){
            return new ModelAndView("redirect:/handphone");
        }
        ModelAndView view = new ModelAndView("handphone/edit");
        view.addObject("handphone",result);
        return view;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id){
        HandphoneEntity result = handphoneService.getById(id);
        if(result == null){
            return new ModelAndView("redirect:/handphone");
        }
        ModelAndView view = new ModelAndView("handphone/detail");
        view.addObject("handphone",result);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute HandphoneDto request){
        handphoneService.update(request.getId(),request);
        return new ModelAndView("redirect:/handphone");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute HandphoneDto request){
        HandphoneEntity result = handphoneService.getById(request.getId());
        if(result == null){
            return new ModelAndView("redirect:/handphone");
        }
        handphoneService.delete(request.getId());
        return new ModelAndView("redirect:/handphone");
    }
}
