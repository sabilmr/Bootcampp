package com.bootcamp.belajarspringjpa.controller;

import com.bootcamp.belajarspringjpa.entity.HandphoneEntity;
import com.bootcamp.belajarspringjpa.model.HandphoneDto;
import com.bootcamp.belajarspringjpa.model.Response;
import com.bootcamp.belajarspringjpa.service.HandphoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hanephone")
public class HandphoneController {
    private HandphoneService hanephoneService;

    public HandphoneController(HandphoneService hanephoneService) {
        this.hanephoneService = hanephoneService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<HandphoneEntity> result = hanephoneService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        HandphoneEntity result = hanephoneService.getById(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));

    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody HandphoneDto request){
        HandphoneEntity result = hanephoneService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PostMapping("save-form1")
    public ResponseEntity<Object> saveForm1(@ModelAttribute HandphoneDto request){
        HandphoneEntity result = hanephoneService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        HandphoneEntity result = hanephoneService.delete(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody HandphoneDto request){
        HandphoneEntity result = hanephoneService.update(id, request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute HandphoneDto request){
        HandphoneEntity result = hanephoneService.update(id, request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200, masage,result));
    }

}
