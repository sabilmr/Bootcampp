package com.bootcamp.belajarspringjpa.controller;

import com.bootcamp.belajarspringjpa.entity.GuruEntity;
import com.bootcamp.belajarspringjpa.model.GuruDto;
import com.bootcamp.belajarspringjpa.model.Response;
import com.bootcamp.belajarspringjpa.service.GuruService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("guru")
public class GuruController {
    private GuruService guruService;

    public GuruController(GuruService guruService) {
        this.guruService = guruService;
    }
    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<GuruEntity> result = guruService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        GuruEntity result = guruService.getById(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody GuruDto request){
        GuruEntity result = guruService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PostMapping("save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute GuruDto request){
        GuruEntity result = guruService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        GuruEntity result = guruService.delete(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody GuruDto request){
        GuruEntity result = guruService.update(id,request);
        String masage = "SUCCES";
        if(result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute GuruDto request){
        GuruEntity result = guruService.update(id, request);
        String masage = "Succes";
        if(result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
}
