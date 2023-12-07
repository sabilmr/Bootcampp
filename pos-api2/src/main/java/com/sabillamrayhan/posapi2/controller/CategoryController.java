package com.sabillamrayhan.posapi2.controller;

import com.sabillamrayhan.posapi2.entity.CategoryEntity;
import com.sabillamrayhan.posapi2.model.CategoryModel;
import com.sabillamrayhan.posapi2.model.Response;
import com.sabillamrayhan.posapi2.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    private ResponseEntity<Response> getAll() {
        List<CategoryEntity> result = categoryService.getAll();
        return ResponseEntity.ok().body(new Response(200, "Success", result));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable("id") Long id){
        Optional<CategoryEntity> result = categoryService.getById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",result));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"Failed","Data not found"));
    }

    @PostMapping()
    private ResponseEntity<Response> save(@RequestBody CategoryModel request){
        Optional<CategoryEntity> result = categoryService.save(request);
        if (result.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",result));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"Failed","Save category failed"));
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@RequestBody CategoryModel request, @PathVariable("id") Long id){
        Optional<CategoryEntity> result = categoryService.update(request, id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",result));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Update category failed"));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable("id") Long id){
        Optional<CategoryEntity> result = categoryService.delete(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",result));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Delete category failed"));
    }
}

