package com.bootcamp.webmvc2.controller;

import com.bootcamp.webmvc2.entity.MotorEntity;
import com.bootcamp.webmvc2.model.MotorDto;
import com.bootcamp.webmvc2.service.MotorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/motor")
public class MotorController {
    private final MotorService motorService;

    public MotorController(MotorService motorService) {
        this.motorService = motorService;
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("motor/index");

        String judul = "JUDUL MOTOR";
        view.addObject("datajudul",judul);

        List<MotorEntity> datamotor = motorService.getAll();
        view.addObject("listMotor",datamotor);

        Integer jumlah = datamotor.size();
        view.addObject("dataJumlah",jumlah);

        return view;
    }
    @GetMapping("add")
    public ModelAndView add(){
        return new ModelAndView("motor/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute MotorDto request){
        motorService.save(request);
        return new ModelAndView("redirect:/motor");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable ("id") Integer id){
        MotorEntity entity = motorService.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/motor");
        }
        ModelAndView view = new ModelAndView("motor/edit");
        view.addObject("motor",entity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute MotorDto request){
        motorService.update(request.getId(), request);
        return new ModelAndView("redirect:/motor");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute MotorDto request){
        MotorEntity entity = motorService.getById(request.getId());
        if (entity == null){
            return new ModelAndView("redirect:/motor");
        }
        motorService.delete(request.getId());
        return new ModelAndView("redirect:/motor");
    }
    @GetMapping("detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id){
        MotorEntity entity = motorService.getById(id);
        if (entity == null){
            return new ModelAndView("redirect:/motor");
        }
        ModelAndView view = new ModelAndView("motor/detail");
        view.addObject("motor",entity);
        return view;
    }
}
