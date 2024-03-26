//Author : Koushal
package com.mercedes.csrwebsite.dao;


import com.mercedes.csrwebsite.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    // Additional queries if needed
	Certificate findById(long id);
}

