//Author : Koushal
package com.mercedes.csrwebsite.dao;

import com.mercedes.csrwebsite.model.VoluntaryRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntaryRegistrationRepository extends JpaRepository<VoluntaryRegistration, Long> {
    // Additional queries if needed
}

