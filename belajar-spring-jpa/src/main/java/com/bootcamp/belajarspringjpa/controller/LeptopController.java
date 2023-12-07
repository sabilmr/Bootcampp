package com.bootcamp.belajarspringjpa.controller;

import com.bootcamp.belajarspringjpa.entity.LeptopEntity;
import com.bootcamp.belajarspringjpa.model.LeptopDto;
import com.bootcamp.belajarspringjpa.model.Response;
import com.bootcamp.belajarspringjpa.service.LeptopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leptop")
public class LeptopController {
    private LeptopService leptopService;

    public LeptopController(LeptopService leptopService) {
        this.leptopService = leptopService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<LeptopEntity> result = leptopService.getAll();
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        LeptopEntity result = leptopService.getById(id);
        return ResponseEntity.ok().body(new Response(200,"SUCCES",result));
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody LeptopDto request){
        LeptopEntity result = leptopService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PostMapping("save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute LeptopDto request){
        LeptopEntity result = leptopService.save(request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        LeptopEntity result = leptopService.delete(id);
        return ResponseEntity.ok().body(new Response(200,"SECCES",result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody LeptopDto request){
        LeptopEntity result = leptopService.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }
    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                             @ModelAttribute LeptopDto request){
        LeptopEntity result = leptopService.update(id,request);
        String masage = "Succes";
        if (result == null){
            masage = "Failed";
        }
        return ResponseEntity.ok().body(new Response(200,masage,result));
    }

}
