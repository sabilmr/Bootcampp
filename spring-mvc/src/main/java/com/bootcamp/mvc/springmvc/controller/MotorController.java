package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.MotorEntity;
import com.bootcamp.mvc.springmvc.model.MotorDto;
import com.bootcamp.mvc.springmvc.service.MotorService;
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
    public ModelAndView getAll(){
         ModelAndView view = new ModelAndView("motor/index");

         String judul = "motor";
         view.addObject("datajudul",judul);

        List<MotorEntity> datamotor = motorService.getAll();
         view.addObject("motor",datamotor);

         Integer jumlah = datamotor.size();
         view.addObject("jumlah",jumlah);
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
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute MotorDto request){
        motorService.update(request.getId(), request);
        return new ModelAndView("redirect:/motor");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable ("id") Integer id){
        MotorEntity result = motorService.getById(id);
        if(result == null){
            return new ModelAndView("redirect:/motor");
        }
        ModelAndView view = new ModelAndView("motor/edit");
        view.addObject("motor",result);
        return view;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute MotorDto request){
        MotorEntity motorEntity = motorService.getById(request.getId());
        if(motorEntity == null){
            return new ModelAndView("redirect:/motor");
        }
        motorService.delete(request.getId());
        return new ModelAndView("redirect:/motor");
    }
    @GetMapping("detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id){
        MotorEntity motorEntity = motorService.getById(id);
        if (motorEntity == null){
            return new ModelAndView("redirect:/motor");
        }
        ModelAndView view = new ModelAndView("motor/detail");
        view.addObject("motor",motorEntity);
        return view;
    }

}
