package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.CameraEntity;
import com.bootcamp.mvc.springmvc.model.CameraDto;
import com.bootcamp.mvc.springmvc.service.CameraService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/camera")
public class CameraController {
    private final CameraService cameraService;

    public CameraController(CameraService cameraService) {
        this.cameraService = cameraService;
    }
    @GetMapping
    public ModelAndView getAll(){
        ModelAndView view = new ModelAndView("camera/index");

        String judul = "Camera";
        view.addObject("datajudul",judul);

        List<CameraEntity> datacamera = cameraService.getAll();
        view.addObject("camera",datacamera);

        Integer jumlah = datacamera.size();
        view.addObject("jumlah",jumlah);
        return view;
    }
    @GetMapping("add")
    public ModelAndView add(){
        return new ModelAndView("camera/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CameraDto request){
        cameraService.save(request);
        return new ModelAndView("redirect:/camera");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable ("id") Integer id){
        CameraEntity cameraEntity = cameraService.getById(id);
        if (cameraEntity == null){
            return new ModelAndView("redirect:/camera");
        }
        ModelAndView view = new ModelAndView("camera/edit");
        view.addObject("camera",cameraEntity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CameraDto request){
        cameraService.update(request.getId(), request);
        return new ModelAndView("redirect:/camera");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute CameraDto request){
        CameraEntity entity = cameraService.getById(request.getId());
        if (entity == null){
            return new ModelAndView("redirect:/camera");
        }
        cameraService.delete(request.getId());
        return new ModelAndView("redirect:/camera");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id){
        CameraEntity cameraEntity = cameraService.getById(id);
        if (cameraEntity == null){
            return new ModelAndView("redirect:/camera");
        }
        ModelAndView view = new ModelAndView("camera/detail");
        view.addObject("camera",cameraEntity);
        return view;

    }
}
