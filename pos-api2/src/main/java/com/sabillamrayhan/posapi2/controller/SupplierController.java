package com.sabillamrayhan.posapi2.controller;

import com.sabillamrayhan.posapi2.entity.SupplierEntity;
import com.sabillamrayhan.posapi2.model.Response;
import com.sabillamrayhan.posapi2.model.SupplierModel;
import com.sabillamrayhan.posapi2.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<SupplierEntity> entity = supplierService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCESS",entity));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable("id") Long id){
        Optional<SupplierEntity> entity = supplierService.getById(id);
        if (entity.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",entity));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"FAILED","Data not found"));
    }

    @PostMapping
    private ResponseEntity<Response> save(@RequestBody SupplierModel request){
        Optional<SupplierEntity> entity = supplierService.save(request);
        if (entity.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",entity));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Save supplier failed"));
    }
    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@RequestBody SupplierModel request, @PathVariable("id") Long id){
        Optional<SupplierEntity> entity = supplierService.update(request, id);
        if (entity.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",entity));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Update supplier failed"));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable("id") Long id){
        Optional<SupplierEntity> entity = supplierService.delete(id);
        if (entity.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"SUCCESS",entity));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"FAILED","Delete supplier failed"));
    }
}
