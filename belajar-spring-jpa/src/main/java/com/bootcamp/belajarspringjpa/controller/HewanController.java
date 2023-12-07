package com.bootcamp.belajarspringjpa.controller;

import com.bootcamp.belajarspringjpa.entity.HewanEntity;
import com.bootcamp.belajarspringjpa.model.HewanDto;
import com.bootcamp.belajarspringjpa.model.Response;
import com.bootcamp.belajarspringjpa.service.HewanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hewan")
public class HewanController {
    private HewanService hewanService;

    public HewanController(HewanService hewanService) {
        this.hewanService = hewanService;
    }
    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<HewanEntity> result = hewanService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        HewanEntity result = hewanService.getById(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody HewanDto request){
        HewanEntity result = hewanService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PostMapping("save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute HewanDto request){
        HewanEntity result = hewanService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete (@PathVariable Integer id){
        HewanEntity result = hewanService.delete(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody HewanDto request){
        HewanEntity result = hewanService.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute HewanDto request){
        HewanEntity result = hewanService.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }

}
