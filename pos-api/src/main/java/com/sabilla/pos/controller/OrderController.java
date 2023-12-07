package com.sabilla.pos.controller;

import com.sabilla.pos.entity.OrderEntity;
import com.sabilla.pos.model.OrderModel;
import com.sabilla.pos.model.Response;
import com.sabilla.pos.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<OrderModel> data = orderService.getAll();
        return ResponseEntity.ok().body(new Response(200,"Success",data));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable ("id") Long id) {
        Optional<OrderModel> data = orderService.getById(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200, "Success", data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"Failed","Data not found"));
    }

    @PostMapping()
    private ResponseEntity<Response> save(@RequestBody OrderModel request){
        Optional<OrderModel> data = orderService.save(request);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"Failed","Save supplier failed"));
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@RequestBody OrderModel request, @PathVariable ("id") Long id){
        Optional<OrderEntity> data = orderService.update(request, id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"Failed","Update supplier failed"));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable ("id") Long id){
        Optional<OrderEntity> data = orderService.delete(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"Failed","Delete supplier failed"));
    }
}
