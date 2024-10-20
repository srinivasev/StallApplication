package com.learning.stall.controller;

import com.learning.stall.dto.StallDTO;
import com.learning.stall.service.StallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StallController {

    @Autowired
    private StallService stallService;

    @GetMapping("/stalls")
    public String getStalls(){
        return "Testing";
    }

    @GetMapping("/stall/{id}")
    public StallDTO getStall(@PathVariable Integer id){
        System.out.println("Retrieve Stall with id " + id);
        //stallService.notifyNewStall();
        return this.stallService.getStallDetailsOnID(id);
    }

    @GetMapping("/stall/category/{category}")
    public StallDTO getStall(@PathVariable("category") String category){
        System.out.println("Retrieve Stall with category " + category);
        return this.stallService.getStallDetailsOnCategory(category);
    }

    @PostMapping("/stall")
    public ResponseEntity<StallDTO> persistStallDetails(@RequestBody StallDTO stallDTO){
        System.out.println("StallDTO toString representation " + stallDTO);
        return ResponseEntity.ok(this.stallService.persistStallDetails(stallDTO));
    }
}
