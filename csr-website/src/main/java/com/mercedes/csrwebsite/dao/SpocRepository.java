//Author : Koushal
package com.mercedes.csrwebsite.dao;


import com.mercedes.csrwebsite.model.Spoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpocRepository extends JpaRepository<Spoc, Long> {
    // Additional queries if needed
	Spoc findById(long id);
}

