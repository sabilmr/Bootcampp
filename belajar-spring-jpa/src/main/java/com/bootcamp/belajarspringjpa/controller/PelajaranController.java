package com.bootcamp.belajarspringjpa.controller;

import com.bootcamp.belajarspringjpa.entity.PelajaranEntity;
import com.bootcamp.belajarspringjpa.model.PelajaranDto;
import com.bootcamp.belajarspringjpa.model.Response;
import com.bootcamp.belajarspringjpa.service.PelajaranService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pelajaran")
public class PelajaranController {
    private PelajaranService pelajaranService;

    public PelajaranController(PelajaranService pelajaranService) {
        this.pelajaranService = pelajaranService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<PelajaranEntity> result = pelajaranService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }
     @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        PelajaranEntity result = pelajaranService.getById(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
     }
     @PostMapping
    public ResponseEntity<Object> save(@RequestBody PelajaranDto request){
        PelajaranEntity result = pelajaranService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
     }
     @PostMapping("save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute PelajaranDto request){
        PelajaranEntity result = pelajaranService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
     }
     @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        PelajaranEntity result = pelajaranService.delete(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
     }
     @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody PelajaranDto request){
        PelajaranEntity result = pelajaranService.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
     }
     @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute PelajaranDto request){
        PelajaranEntity result = pelajaranService.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
     }

}
