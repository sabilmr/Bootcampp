package com.sabillamrayhan.posapi3.controller;

import com.sabillamrayhan.posapi3.entity.CustomerEntity;
import com.sabillamrayhan.posapi3.model.CustomerModel;
import com.sabillamrayhan.posapi3.model.Response;
import com.sabillamrayhan.posapi3.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/customer")
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<CustomerModel> data = this.service.getAll();
        return ResponseEntity.ok()
                .body(new Response(200,"SUCCESS", data));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable("id") Long id){
        Optional<CustomerEntity> data = this.service.getById(id);
        if(data.isPresent()) {
            return ResponseEntity.ok()
                    .body(new Response(200, "SUCCESS", data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Response(400,"FAILED","Data not found"));
    }

    @PostMapping()
    private ResponseEntity<Response> save(@RequestBody CustomerModel request){
        Optional<CustomerEntity> data = this.service.save(request);
        if(data.isPresent()) {
            return ResponseEntity.ok()
                    .body(new Response(200, "SUCCESS", data));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response(500,"FAILED","Save customer failed"));
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@RequestBody CustomerModel request, @PathVariable("id") Long id){
        Optional<CustomerEntity> data = this.service.update(request, id);
        if(data.isPresent()) {
            return ResponseEntity.ok()
                    .body(new Response(200, "SUCCESS", data));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response(500,"FAILED","Update customer failed"));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable("id") Long id){
        Optional<CustomerEntity> data = this.service.delete(id);
        if(data.isPresent()) {
            return ResponseEntity.ok()
                    .body(new Response(200, "SUCCESS", data));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response(500,"FAILED","Delete customer failed"));
    }
}
