package com.sabilla.pos.controller;

import com.sabilla.pos.entity.CategoryEntity;
import com.sabilla.pos.model.CategoryModel;
import com.sabilla.pos.model.Response;
import com.sabilla.pos.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<CategoryEntity> data = categoryService.getAll();
         return ResponseEntity.ok().body(new Response(200,"Success",data));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable ("id") Long id){
        Optional<CategoryEntity> data = categoryService.getById(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(500,"Failed","Data not found"));
    }

    @PostMapping("")
    private ResponseEntity<Response> save(@RequestBody CategoryModel request){
        Optional<CategoryEntity> data = categoryService.save(request);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(500,"Failed","Save category failed"));
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@RequestBody CategoryModel request, @PathVariable ("id") Long id){
        Optional<CategoryEntity> data = categoryService.update(request, id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(500,"Failed","Update category failed"));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable ("id") Long id){
        Optional<CategoryEntity> data = categoryService.delete(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(500,"Failed","Delete category failed"));
    }
}
