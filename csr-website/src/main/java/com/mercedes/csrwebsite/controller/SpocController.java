//Author : Koushal
package com.mercedes.csrwebsite.controller;



import com.mercedes.csrwebsite.model.Spoc;
import com.mercedes.csrwebsite.service.SpocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/spocs")
public class SpocController {
    private final SpocService spocService;

    @Autowired
    public SpocController(SpocService spocService) {
        this.spocService = spocService;
    }

    @GetMapping("/getAllSpocs")
    public List<Spoc> getAllSpocs() {
        return spocService.getAllSpocs();
    }

    @PostMapping("/createSpoc")
    public Spoc createSpoc(@RequestBody Spoc spoc) {
        return spocService.createSpoc(spoc);
    }
    
    @PutMapping("/updateSpoc")
    public Spoc updateSpoc(@RequestBody Spoc spoc) {
        return spocService.updateSpoc(spoc);
    }
    
    @DeleteMapping("/deleteSpoc/{id}")
    public void deleteSpoc(@PathVariable Long id) {
        spocService.deleteSpoc(id);
    }

    @GetMapping("/getSpocById/{id}")
    public Optional<Spoc> getSpocById(@PathVariable Long id) {
        return spocService.getSpocById(id);
    }

    // Other controller methods for updating and deleting Spocs if needed
}

