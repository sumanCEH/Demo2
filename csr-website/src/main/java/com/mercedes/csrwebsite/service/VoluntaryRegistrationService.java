//Author : Koushal
package com.mercedes.csrwebsite.service;

import com.mercedes.csrwebsite.dao.VoluntaryRegistrationRepository;
import com.mercedes.csrwebsite.model.VoluntaryRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoluntaryRegistrationService {

    private final VoluntaryRegistrationRepository voluntaryRegistrationRepository;

    @Autowired
    public VoluntaryRegistrationService(VoluntaryRegistrationRepository voluntaryRegistrationRepository) {
        this.voluntaryRegistrationRepository = voluntaryRegistrationRepository;
    }

    public List<VoluntaryRegistration> getAllRegistrations() {
        return voluntaryRegistrationRepository.findAll();
    }

    public Optional<VoluntaryRegistration> getRegistrationById(Long id) {
        return voluntaryRegistrationRepository.findById(id);
    }

    public VoluntaryRegistration createRegistration(VoluntaryRegistration registration) {
        // Additional business logic or validation can be added here before saving to the database
        return voluntaryRegistrationRepository.save(registration);
    }

    public void deleteRegistration(Long id) {
        voluntaryRegistrationRepository.deleteById(id);
    }

    // Other methods for updating registrations if needed
}

