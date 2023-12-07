package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.Kendaraan;
import com.bootcamp.belajarspring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kendaraan")
public class MobilController {

    @PostMapping("/data")
    public ResponseEntity<Object> postData(@RequestBody Kendaraan request){
        Response result = new Response(200,"SUCCES",request);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @PostMapping("/data1")
    public ResponseEntity<Object> postData1(@RequestBody Kendaraan request) {
        Response result = new Response(200, "SUCCES", request);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @PostMapping("/data2")
    public ResponseEntity<Object> postData2(@RequestBody Kendaraan request){
        Response result = new Response(200, "SUCCES",request);
        return ResponseEntity
                .ok()
                .body(result);
    }
}
