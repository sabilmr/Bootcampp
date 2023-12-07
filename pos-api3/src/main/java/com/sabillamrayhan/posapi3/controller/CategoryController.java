package com.sabillamrayhan.posapi3.controller;

import com.sabillamrayhan.posapi3.entity.CategoryEntity;
import com.sabillamrayhan.posapi3.model.CategoryModel;
import com.sabillamrayhan.posapi3.model.Response;
import com.sabillamrayhan.posapi3.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<CategoryEntity> sabil = categoryService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable("id") Long id){
        Optional<CategoryEntity> sabil = categoryService.getById(id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"FAILED","Data not found"));
    }

    @PostMapping
    private ResponseEntity<Response> save(@RequestBody CategoryModel request){
        Optional<CategoryEntity> sabil = categoryService.save(request);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Save category failed"));
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@RequestBody CategoryModel request, @PathVariable("id") Long id){
        Optional<CategoryEntity> sabil = categoryService.update(request, id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Update category failed"));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable("id") Long id){
        Optional<CategoryEntity> sabil = categoryService.delete(id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Delete category failed"));
    }

}
