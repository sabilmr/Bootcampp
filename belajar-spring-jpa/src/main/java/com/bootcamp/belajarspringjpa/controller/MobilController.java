package com.bootcamp.belajarspringjpa.controller;

import com.bootcamp.belajarspringjpa.entity.MobilEntity;
import com.bootcamp.belajarspringjpa.model.MobilDto;
import com.bootcamp.belajarspringjpa.model.Response;
import com.bootcamp.belajarspringjpa.service.MobilServie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mobil")
public class MobilController {
    private MobilServie mobilServie;

    public MobilController(MobilServie mobilServie) {
        this.mobilServie = mobilServie;
    }
    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<MobilEntity> result = mobilServie.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        MobilEntity result = mobilServie.getById(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody MobilDto request){
        MobilEntity result = mobilServie.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PostMapping("save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute MobilDto request){
        MobilEntity result = mobilServie.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return  ResponseEntity.ok().body(new Response(200,masage,result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        MobilEntity result = mobilServie.delete(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody MobilDto request){
        MobilEntity result = mobilServie.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute MobilDto request){
        MobilEntity result = mobilServie.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
}
