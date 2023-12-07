package com.bootcamp.belajarspringjpa.controller;

import com.bootcamp.belajarspringjpa.entity.SepedaEntity;
import com.bootcamp.belajarspringjpa.model.Response;
import com.bootcamp.belajarspringjpa.model.SepedaDto;
import com.bootcamp.belajarspringjpa.repository.SepedaRepo;
import com.bootcamp.belajarspringjpa.service.SepedaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sepeda")
public class SepedaController {
    private SepedaService sepedaService;

    public SepedaController(SepedaService sepedaService) {
        this.sepedaService = sepedaService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<SepedaEntity> result = sepedaService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        SepedaEntity result = sepedaService.getById(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody SepedaDto request){
        SepedaEntity result = sepedaService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PostMapping("save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute SepedaDto request){
        SepedaEntity result = sepedaService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        SepedaEntity result = sepedaService.delete(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody SepedaDto request){
        SepedaEntity result = sepedaService.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute SepedaDto request){
        SepedaEntity result = sepedaService.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }

}
