package com.bootcamp.belajarspringjpa1.controller;

import com.bootcamp.belajarspringjpa1.entity.LeptopEntity;
import com.bootcamp.belajarspringjpa1.model.LeptopDto;
import com.bootcamp.belajarspringjpa1.model.Response;
import com.bootcamp.belajarspringjpa1.service.LeptopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leptop")
public class LeptopController {
    private final LeptopService leptopService;

    public LeptopController(LeptopService leptopService) {
        this.leptopService = leptopService;
    }
    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<LeptopEntity> result = leptopService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }
    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody LeptopDto request){
        LeptopEntity result = leptopService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PostMapping("/save-form")
    public ResponseEntity<Object> saveform(@ModelAttribute LeptopDto request){
        LeptopEntity result = leptopService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        LeptopEntity entity = leptopService.delete(id);
        return ResponseEntity.ok().body(new Response(200,"SUSSES",entity));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody LeptopDto request){
        LeptopEntity entity = leptopService.update(id,request);
        String masage = "Succes";
        if (entity == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,entity));
    }
}
