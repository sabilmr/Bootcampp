package com.sabilla.nortwinddapp.controller;

import com.sabilla.nortwinddapp.model.entity.LookUpEntity;
import com.sabilla.nortwinddapp.model.response.CategoryResponse;
import com.sabilla.nortwinddapp.service.CategoryService;
import com.sabilla.nortwinddapp.service.LookUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final LookUpService lookUpService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/category/index");
        List<CategoryResponse> category = categoryService.getAll();

        view.addObject("listCategory", category);
        return view;
    }

    @GetMapping("/add-modal")
    public ModelAndView addModal(){
        ModelAndView view = new ModelAndView("pages/category/_addPartial");

        view.addObject("category", lookUpService.getByGroups("CATEGORY"));
        view.addObject("byPosition", Comparator.comparing(LookUpEntity::getPosition));
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CategoryResponse response){
        if (response == null){
            return new ModelAndView("redirect:/category/add");
        }

        if (response.getDesc().isEmpty()){
            return new ModelAndView("redirect:/category/add");
        }
        categoryService.save(response);
        return new ModelAndView("redirect:/category");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/category/edit");
        CategoryResponse response = categoryService.getById(id);
        if (response == null){
            return new ModelAndView("redirect:/category");
        }

        view.addObject("category", lookUpService.getByGroups("CATEGORY"));

        view.addObject("byPosition", Comparator.comparing(LookUpEntity::getPosition));

        view.addObject("category", response);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CategoryResponse response){
        categoryService.update(response, response.getId());
        return new ModelAndView("redirect:/category");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/category/delete");
        CategoryResponse data = categoryService.getById(id);
        if (data == null) {
            return new ModelAndView("redirect:/category");
        }

        view.addObject("data",data);
        return view;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/category/detail");
        CategoryResponse response = categoryService.getById(id);
        if (response == null){
            return new ModelAndView("redirect:/category");
        }

        view.addObject("category", response);
        return view;
    }

    @PostMapping("/delete-save")
    public String delete(@ModelAttribute CategoryResponse response){
        categoryService.delete(response.getId());
        return "redirect:/category";
    }
}
