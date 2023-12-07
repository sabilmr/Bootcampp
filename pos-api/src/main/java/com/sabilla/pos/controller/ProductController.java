package com.sabilla.pos.controller;

import com.sabilla.pos.entity.ProductEntity;
import com.sabilla.pos.model.ProductRequest;
import com.sabilla.pos.model.Response;
import com.sabilla.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<ProductEntity> data = productService.getAll();
        return ResponseEntity.ok().body(new Response(200,"Success",data));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable ("id") Long id){
        Optional<ProductEntity> data = productService.getById(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(500,"Failed","Data not Found"));
    }

    @PostMapping("")
    private ResponseEntity<Response> save(@RequestBody ProductRequest request){
        Optional<ProductEntity> data = productService.save(request);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(500,"Failed","Save product failed"));
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@RequestBody ProductRequest request, @PathVariable ("id") Long id){
        Optional<ProductEntity> data = productService.update(request, id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(500,"Failed","Update product failed"));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable ("id") Long id){
        Optional<ProductEntity> data = productService.delete(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(500,"Failed","Delete product failed"));
    }
}
