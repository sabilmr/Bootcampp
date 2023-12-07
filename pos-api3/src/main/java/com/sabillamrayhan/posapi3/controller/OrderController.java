package com.sabillamrayhan.posapi3.controller;

import com.sabillamrayhan.posapi3.model.OrderModel;
import com.sabillamrayhan.posapi3.model.Response;
import com.sabillamrayhan.posapi3.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<OrderModel> model = orderService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCESS",model));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable("id") Long id){
        Optional<OrderModel> model = orderService.getById(id);
        if (model.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",model));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"FAILED","Data Not found"));
    }

    @PostMapping
    private ResponseEntity<Response> save(@RequestBody OrderModel request){
        Optional<OrderModel> model = orderService.save(request);
        if (model.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",model));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Save order failed"));
    }
}
