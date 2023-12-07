package com.sabilla.pos.controller;

import com.sabilla.pos.entity.SupplierEntity;
import com.sabilla.pos.model.Response;
import com.sabilla.pos.model.SupplierModel;
import com.sabilla.pos.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping
    private ResponseEntity<Response> getAll(){
        List<SupplierEntity> data = supplierService.getAll();
        return ResponseEntity.ok().body(new Response(200,"Success",data));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable ("id") Long id) {
        Optional<SupplierEntity> data = supplierService.getById(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200, "Success", data));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400,"Failed","Data not found"));
    }

    @PostMapping()
    private ResponseEntity<Response> save(@RequestBody SupplierModel request){
        Optional<SupplierEntity> data = supplierService.save(request);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"Failed","Save supplier failed"));
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@RequestBody SupplierModel request, @PathVariable ("id") Long id){
        Optional<SupplierEntity> data = supplierService.update(request, id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"Failed","Update supplier failed"));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable ("id") Long id){
        Optional<SupplierEntity> data = supplierService.delete(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(new Response(200,"Success",data));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(500,"Failed","Delete supplier failed"));
    }
}
