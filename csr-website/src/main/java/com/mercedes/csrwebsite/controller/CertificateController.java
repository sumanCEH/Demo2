package com.mercedes.csrwebsite.controller;

import com.mercedes.csrwebsite.model.Certificate;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.mercedes.csrwebsite.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

	private CertificateService certificateService;

	@Autowired
	public CertificateController(CertificateService certificateService) {
		this.certificateService = certificateService;
	}

	@GetMapping("/getAllCertificate")
	public ResponseEntity<?> getAllCertificates() {
		List<Certificate> certificates = certificateService.getAllCertificates();
		if (certificates.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No certificates available");
		} else {
			return ResponseEntity.ok(certificates);
		}
	}

	@PostMapping("/createCertificate")
	public Certificate createCertificate(@RequestBody Certificate certificate) {
		return certificateService.createCertificate(certificate);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCertificateById(@PathVariable Long id) {
		try {
			Certificate certificate = certificateService.getCertificateById(id)
					.orElseThrow(() -> new NoSuchElementException("Certificate not found with id: " + id));
			return ResponseEntity.ok(certificate);
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Certificate not found with id: " + id);
		}
	}

	@PutMapping("updateCertificate/{id}")
	public ResponseEntity<?> updateCertificate(@PathVariable Long id, @RequestBody Certificate certificate) {
		try {
			// Check if the certificate with the given ID exists
			Optional<Certificate> existingCertificateOptional = certificateService.getCertificateById(id);
			if (existingCertificateOptional.isPresent()) {
				Certificate existingCertificate = existingCertificateOptional.get();

				// Ensure the provided ID matches the ID in the Certificate object
				if (!existingCertificate.getId().equals(certificate.getId())) {
					return ResponseEntity.badRequest()
							.body("ID in the path variable does not match the ID in the request body");
				}

				// Update only the allowed fields (userId, eventId, type)
				existingCertificate.setUserId(certificate.getUserId());
				existingCertificate.setEventId(certificate.getEventId());
				existingCertificate.setType(certificate.getType());

				// Update the certificate
				Certificate updatedCertificate = certificateService.updateCertificate(existingCertificate);
				return ResponseEntity.ok(updatedCertificate);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to update certificate: " + e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCertificate(@PathVariable Long id) {
		try {
			certificateService.deleteCertificate(id);
			return ResponseEntity.ok("Certificate deleted successfully");
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Certificate not found with ID: " + id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred while deleting the certificate, Id doesnt Exist");
		}
	}

	// Other controller methods for updating and deleting Certificates if needed
}
