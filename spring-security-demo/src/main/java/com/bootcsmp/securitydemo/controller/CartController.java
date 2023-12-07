package com.bootcsmp.securitydemo.controller;

import com.bootcsmp.securitydemo.dto.CartDto;
import com.bootcsmp.securitydemo.dto.Response;
import com.bootcsmp.securitydemo.entity.CartEntity;
import com.bootcsmp.securitydemo.entity.ProductEntity;
import com.bootcsmp.securitydemo.repository.ProductRepo;
import com.bootcsmp.securitydemo.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final ProductRepo productRepo;

    @GetMapping("")
    public ResponseEntity<Response> getAll(){
        List<CartEntity> result = cartService.getAll();
        return ResponseEntity.ok().body(new Response(200,"Succes",result));
    }

    @GetMapping(value = "/product", produces = {"application/json"})
    public ResponseEntity<Response> getProduct(){
        List<ProductEntity> result = productRepo.findAll();
        return ResponseEntity.ok().body(new Response(200,"Success",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable ("id") String id){
        return ResponseEntity.ok().body(new Response(200,"Succes",cartService.getById(id)));
    }
    @PostMapping("")
    public ResponseEntity<Response> save(@RequestBody CartDto request){
        Optional<CartEntity> result = cartService.save(request);

        if (result.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",result));

        } else {
            return ResponseEntity.status(500).body(new Response(500,"Failed",null));
        }
    }
    @PostMapping("/simple")
    public ResponseEntity<Response> simpleSave(@RequestBody CartDto request){
        Optional<CartEntity> result = cartService.simpleSave(request);

        if (result.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Succes",result));

        }else {
            return ResponseEntity.status(500).body(new Response(500,"Failed",null));
        }
    }
}
