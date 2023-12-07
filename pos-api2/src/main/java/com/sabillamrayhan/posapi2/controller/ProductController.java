package com.sabillamrayhan.posapi2.controller;

import com.sabillamrayhan.posapi2.entity.ProductEntity;
import com.sabillamrayhan.posapi2.model.ProductModel;
import com.sabillamrayhan.posapi2.model.Response;
import com.sabillamrayhan.posapi2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<ProductEntity> sabil = productService.getAll();
        return ResponseEntity.ok().body(new Response(200,"Success",sabil));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable("id") Long id){
        Optional<ProductEntity> sabil = productService.getById(id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",sabil));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"FAILED","Data not found"));
    }

    @PostMapping()
    private ResponseEntity<Response> save(@RequestBody ProductModel request){
        Optional<ProductEntity> sabil = productService.save(request);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Save product failed"));
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@RequestBody ProductModel request, @PathVariable("id") Long id){
        Optional<ProductEntity> sabil = productService.update(request, id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","update product failed"));
     }

     @DeleteMapping("/{id}")
     private ResponseEntity<Response> delete(@PathVariable("id") Long id){
        Optional<ProductEntity> sabil = productService.delete(id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Delete product failed"));
     }
}
