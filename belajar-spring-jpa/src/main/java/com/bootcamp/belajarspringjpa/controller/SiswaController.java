package com.bootcamp.belajarspringjpa.controller;

import com.bootcamp.belajarspringjpa.entity.SiswaEntity;
import com.bootcamp.belajarspringjpa.model.Response;
import com.bootcamp.belajarspringjpa.model.SiswaDto;
import com.bootcamp.belajarspringjpa.service.SiswaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siswa")
public class SiswaController {
    private SiswaService siswaService;

    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }
    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<SiswaEntity> result = siswaService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        SiswaEntity result = siswaService.getById(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody SiswaDto request){
        SiswaEntity result = siswaService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PostMapping("save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute SiswaDto request){
        SiswaEntity result = siswaService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        SiswaEntity result = siswaService.delete(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody SiswaDto request){
        SiswaEntity result = siswaService.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute SiswaDto request){
        SiswaEntity result = siswaService.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }

}
