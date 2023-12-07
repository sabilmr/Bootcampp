package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.LeptopEntity;
import com.bootcamp.mvc.springmvc.model.LeptopDto;
import com.bootcamp.mvc.springmvc.service.LeptopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/leptop")
public class LeptopController {
    private final LeptopService leptopService;

    public LeptopController(LeptopService leptopService) {
        this.leptopService = leptopService;
    }
    @GetMapping
    public ModelAndView getAll(){
        ModelAndView view = new ModelAndView("leptop/index");

        String judul = "leptop";
        view.addObject("datajudul",judul);

        List<LeptopEntity> dataLeptop = leptopService.getAll();
        view.addObject("leptop",dataLeptop);

        Integer jumlah = dataLeptop.size();
        view.addObject("jumlah",jumlah);

        return view;
    }
    @GetMapping("add")
    public ModelAndView add(){
        return new ModelAndView("leptop/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute LeptopDto request){
        leptopService.save(request);
        return new ModelAndView("redirect:/leptop");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable ("id") Integer id){
        LeptopEntity result = leptopService.getById(id);
        if(result == null){
            return new ModelAndView("redirect:/leptop");
        }
        ModelAndView view = new ModelAndView("leptop/edit");
        view.addObject("leptop",result);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute LeptopDto request){
        leptopService.update(request.getId(), request);
        return new ModelAndView("redirect:/leptop");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute LeptopDto request){
        LeptopEntity result = leptopService.getById(request.getId());
        if(result == null){
            return new ModelAndView("redirect:/leptop");
        }
        leptopService.delete(request.getId());
        return new ModelAndView("redirect:/leptop");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable ("id") Integer id) {
        LeptopEntity result = leptopService.getById(id);
        if (result == null) {
            return new ModelAndView("redirect:/leptop");
        }
        ModelAndView view = new ModelAndView("leptop/detail");
        view.addObject("leptop",result);
        return view;
    }
}
