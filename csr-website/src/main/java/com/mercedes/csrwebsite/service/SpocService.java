//Author : Koushal
package com.mercedes.csrwebsite.service;


import com.mercedes.csrwebsite.dao.SpocRepository;
import com.mercedes.csrwebsite.model.Spoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpocService {
    private final SpocRepository spocRepository;

    @Autowired
    public SpocService(SpocRepository spocRepository) {
        this.spocRepository = spocRepository;
    }

    public List<Spoc> getAllSpocs() {
        return spocRepository.findAll();
    }

    public Spoc createSpoc(Spoc spoc) {
        // Additional business logic or validation can be added here before saving to the database
        return spocRepository.save(spoc);
    }

    public void identifySpoc(Spoc spoc) {
        try {
            //Setting a flag in the Spoc object
            spoc.setIdentified(true);

            // Save the updated Spoc to the database
            spocRepository.save(spoc);

            // Log or handle success if needed
            System.out.println("SPOC identified successfully");

        } catch (Exception e) {
            // Log or handle any exceptions that occur during the identification process
            System.err.println("Failed to identify SPOC: " + e.getMessage());
        }
    }
    
    
    public Optional<Spoc> getSpocById(Long id) {
        return spocRepository.findById(id);
    }
 
    public void deleteSpoc(Long id) {
        spocRepository.deleteById(id);
    }
    
    public Spoc updateSpoc(Spoc spoc) {
        return spocRepository.save(spoc);
    }


    // Other methods for updating and deleting Spocs if needed
}

