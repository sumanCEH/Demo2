//Author : Koushal
package com.mercedes.csrwebsite.service;

import com.mercedes.csrwebsite.dao.CertificateRepository;
import com.mercedes.csrwebsite.model.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {
	
	
    private CertificateRepository certificateRepository;

    @Autowired
    public CertificateService(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    public Certificate createCertificate(Certificate certificate) {
        // Set the createdAt field to the current system time before saving
        certificate.setCreatedAt(new Date(System.currentTimeMillis()));
        return certificateRepository.save(certificate);
    }
    
    public Optional<Certificate> getCertificateById(Long id) {
        return certificateRepository.findById(id);
    }

    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }

    public Certificate updateCertificate(Certificate certificate) {
        certificate.setUpdatedAt(new Date(System.currentTimeMillis()));
        return certificateRepository.save(certificate);
    }

    // Other methods for updating and deleting Certificates if needed
    
	

    //error //Author : Lokesh
    /*public Certificate updateCertificate(Certificate certificate) {
    	certificate.setCreatedAt(new Date());
    	certificate.setUpdatedAt(new Date());
		return certificateRepository.save(certificate);
	}*/
}

