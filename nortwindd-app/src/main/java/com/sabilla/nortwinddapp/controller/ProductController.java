package com.sabilla.nortwinddapp.controller;

import com.sabilla.nortwinddapp.model.entity.LookUpEntity;
import com.sabilla.nortwinddapp.model.response.CategoryResponse;
import com.sabilla.nortwinddapp.model.response.ProductResponse;
import com.sabilla.nortwinddapp.model.response.SupplierResponse;
import com.sabilla.nortwinddapp.service.CategoryService;
import com.sabilla.nortwinddapp.service.LookUpService;
import com.sabilla.nortwinddapp.service.ProductService;
import com.sabilla.nortwinddapp.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final SupplierService supplierService;
    private final LookUpService lookUpService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/product/index");
        List<ProductResponse> requests = productService.getAll();

        view.addObject("dataProduct", requests);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/product/add");

        view.addObject("dataList",lookUpService.getByGroups("CATEGORY"));
        view.addObject("byPosition", Comparator.comparing(LookUpEntity::getPosition));

        view.addObject("productList", new ProductResponse());
        return view;
    }


    @GetMapping("/add-modal")
    public ModelAndView addModel(){
        ModelAndView view = new ModelAndView("pages/product/_addPartial");

        List<SupplierResponse> supplier = supplierService.getAll();

        view.addObject("dataList", lookUpService.getByGroups("CATEGORY"));

        view.addObject("byPosition", Comparator.comparing(LookUpEntity::getPosition));

        view.addObject("supplier", supplier);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductResponse response){
        productService.save(response);
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/product/edit");
        ProductResponse response = productService.getById(id);
        if (response == null){
            return new ModelAndView("redirect:/product");
        }

        List<SupplierResponse> supplier = supplierService.getAll();

        view.addObject("editSupplier", supplier);

        view.addObject("editProduct", response);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductResponse response){
        productService.update(response, response.getId());
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/product/delete");
        ProductResponse response = productService.getById(id);
        if (response == null){
            return new ModelAndView("redirect:/product");
        }

        view.addObject("product", response);
        return view;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/product/detail");
        ProductResponse response = productService.getById(id);
        if (response == null) {
            return new ModelAndView("redirect:/product");
        }
        view.addObject("detailProduct", response);
        return view;
    }

    @PostMapping("/delete-save")
    public String delete(@ModelAttribute ProductResponse response){
        productService.delete(response.getId());
        return "redirect:/product";
    }
}
