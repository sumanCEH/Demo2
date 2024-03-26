//Author : Koushal
package com.mercedes.csrwebsite.controller;


import com.mercedes.csrwebsite.model.VoluntaryRegistration;
import com.mercedes.csrwebsite.service.VoluntaryRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntaryRegistrations")
public class VoluntaryRegistrationController {

    private final VoluntaryRegistrationService voluntaryRegistrationService;

    @Autowired
    public VoluntaryRegistrationController(VoluntaryRegistrationService voluntaryRegistrationService) {
        this.voluntaryRegistrationService = voluntaryRegistrationService;
    }

    @GetMapping("/getAllRegistration")
    public List<VoluntaryRegistration> getAllRegistrations() {
        return voluntaryRegistrationService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public VoluntaryRegistration getRegistrationById(@PathVariable Long id) {
        return voluntaryRegistrationService.getRegistrationById(id).orElse(null);
    }

    @PostMapping("/createRegistration")
    public VoluntaryRegistration createRegistration(@RequestBody VoluntaryRegistration registration) {
        return voluntaryRegistrationService.createRegistration(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        voluntaryRegistrationService.deleteRegistration(id);
    }

    // Other controller methods for updating registrations if needed
}

