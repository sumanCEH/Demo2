package com.mercedes.csrwebsite.service;

import com.mercedes.csrwebsite.dao.CertificateRepository;
import com.mercedes.csrwebsite.model.Certificate;
import com.mercedes.csrwebsite.service.CertificateService;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CertificateServiceTest {

    @Mock
    private CertificateRepository certificateRepository;

    @InjectMocks
    private CertificateService certificateService;

    @Disabled
    @Test
    public void testGetAllCertificates() {
        // Mock the CertificateRepository behavior
        when(certificateRepository.findAll()).thenReturn(Collections.singletonList(new Certificate()));

        // Call the service method
        List<Certificate> certificates = certificateService.getAllCertificates();

        // Verify the result
        assertEquals(1, certificates.size());
    }

    @Disabled
    @Test
    public void testCreateCertificate() {
        // Create a Certificate object for testing
        Certificate certificate = new Certificate();
        certificate.setType("Achievement");

        // Mock the CertificateRepository behavior
        when(certificateRepository.save(certificate)).thenReturn(certificate);

        // Call the service method
        Certificate createdCertificate = certificateService.createCertificate(certificate);

        // Verify the result
        assertEquals("Achievement", createdCertificate.getType());
        // Add more assertions based on your Certificate object properties
    }

    // Add more test cases for other service methods as needed
}
