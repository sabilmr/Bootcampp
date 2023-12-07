package com.sabillamrayhan.posapi2.controller;

import com.sabillamrayhan.posapi2.entity.OrderEntity;
import com.sabillamrayhan.posapi2.model.OrderModel;
import com.sabillamrayhan.posapi2.model.Response;
import com.sabillamrayhan.posapi2.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<OrderModel> sabil = orderService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
    }
    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable ("id") Long id){
        Optional<OrderModel> sabil = orderService.getById(id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"FAILED","Data not found"));
    }
    @PostMapping()
    private ResponseEntity<Response> save(@RequestBody OrderModel request){
        Optional<OrderModel> sabil = orderService.save(request);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Save customer failed"));
    }
    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@RequestBody OrderModel request, @PathVariable ("id") Long id){
        Optional<OrderEntity> sabil = orderService.update(request, id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Update customer failed"));
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable("id") Long id){
        Optional<OrderEntity> sabil = orderService.delete(id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Delete customer failed"));
    }
}
