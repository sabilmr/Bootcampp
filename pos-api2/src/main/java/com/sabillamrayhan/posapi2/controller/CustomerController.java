package com.sabillamrayhan.posapi2.controller;

import com.sabillamrayhan.posapi2.entity.CustomerEntity;
import com.sabillamrayhan.posapi2.model.CustomerModel;
import com.sabillamrayhan.posapi2.model.Response;
import com.sabillamrayhan.posapi2.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<CustomerModel> sabil = customerService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
    }
    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable ("id") Long id){
        Optional<CustomerModel> sabil = customerService.getById(id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"FAILED","Data not found"));
    }
    @PostMapping()
    private ResponseEntity<Response> save(@RequestBody CustomerModel request){
        Optional<CustomerEntity> sabil = customerService.save(request);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Save customer failed"));
    }
    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@RequestBody CustomerModel request, @PathVariable ("id") Long id){
        Optional<CustomerEntity> sabil = customerService.update(request, id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Update customer failed"));
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable("id") Long id){
        Optional<CustomerEntity> sabil = customerService.delete(id);
        if (sabil.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",sabil));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Delete customer failed"));
    }
}
