package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.Orang;
import com.bootcamp.belajarspring.model.Pelajaran;
import com.bootcamp.belajarspring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pelajaran")
public class PelajaranController {

    @GetMapping("/data")
    public Pelajaran getData(){
        return new Pelajaran("Senin","Matematika","Bu Nita", "07.00 WIB");
    }
    @GetMapping("/data1")
    public Pelajaran getData1(){
        return new Pelajaran("Selasa", "B.Indonesia", "Pak Roni","08.00 WIB");
    }
    @GetMapping("/data2")
    public Pelajaran getData2(){
        return new Pelajaran("Rabu","B.Jawa","Pak Bagus","09.00 WIB");
    }
    @GetMapping("/data3")
    public Pelajaran getData3(){
        return new Pelajaran("Kamis","Teknik Permesinan","Bu Arini","10.00 WIB");
    }
    @GetMapping("/data4")
    public Pelajaran getData4(){
        return new Pelajaran("Jum'at","B.Inggris","Pak Budi","11.00 WIB");
    }
    @GetMapping("/data5")
    public Pelajaran getData5(){
        return new Pelajaran("Sabtu","Pendidikan Agama Islam","Bu Rosia","12.00 WIB");
    }
    @PostMapping("/data6")
    public ResponseEntity<Object> postData6(@RequestBody Pelajaran request){
        Response result = new Response(200,"SUCCESS",request);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @PostMapping("/data7")
    public ResponseEntity<Object> postData7(@RequestBody Pelajaran request){
        Response result = new Response(200,"SUCCESS",request);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @PostMapping("/orang")
    public ResponseEntity<Object> postOrang(@RequestBody Orang request){
        Response result = new Response(200,"SUCESS",request);
        return ResponseEntity
                .ok()
                .body(result);
    }

}
