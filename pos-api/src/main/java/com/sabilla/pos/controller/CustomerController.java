package com.sabilla.pos.controller;

import com.sabilla.pos.entity.CustomerEntity;
import com.sabilla.pos.model.CustomerModel;
import com.sabilla.pos.model.Response;
import com.sabilla.pos.model.response.CustomerResponse;
import com.sabilla.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<CustomerResponse> data = customerService.getAll();
        return ResponseEntity.ok().body(new Response(200,"success",data));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable ("id") Long id){
        Optional<CustomerEntity> data = customerService.getById(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"Failed","Data not found"));
    }

    @PostMapping()
    private ResponseEntity<Response> save(@RequestBody CustomerModel request){
        Optional<CustomerEntity> data = customerService.save(request);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"Failed","Save customer failed"));
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response> save(@RequestBody CustomerModel request, @PathVariable ("id") Long id){
        Optional<CustomerEntity> data = customerService.update(request, id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"Failed","Update customer failed"));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable ("id") Long id){
        Optional<CustomerEntity> data = customerService.delete(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"Failed","Delete customer failed"));
    }
}
