//Author : Koushal
package com.mercedes.csrwebsite.controller;

import com.mercedes.csrwebsite.model.Faq;
import com.mercedes.csrwebsite.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faqs")
public class FaqController {
	private final FaqService faqService;

	@Autowired
	public FaqController(FaqService faqService) {
		this.faqService = faqService;
	}

	@GetMapping("/getAllFaqs")
	public List<Faq> getAllFaqs() {
		return faqService.getAllFaqs();
	}

	@GetMapping("/{id}") // validation
	public ResponseEntity<?> getFaqById(@PathVariable Long id) {
		Optional<Faq> faqOptional = faqService.getFaqById(id);
		if (faqOptional.isPresent()) {
			// FAQ exists, return it
			return ResponseEntity.ok(faqOptional.get());
		} else {
			// FAQ does not exist
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FAQ with ID " + id + " not found");
		}
	}

	// Should be provided only for admin
	@PostMapping("/createFaq")
	public Faq createFaq(@RequestBody Faq faq) {
		return faqService.createFaq(faq);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFaq(@PathVariable Long id) {
		Optional<Faq> faqOptional = faqService.getFaqById(id);
		if (faqOptional.isPresent()) {
			// FAQ exists, proceed with deletion
			faqService.deleteFaq(id);
			return ResponseEntity.ok("FAQ deleted successfully");
		} else {
			// FAQ does not exist
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FAQ with ID " + id + " not found");
		}
	}

	@PutMapping("/{id}") // Update FAQ by ID
	public ResponseEntity<String> updateFaq(@PathVariable Long id, @RequestBody Faq faq) {
		Optional<Faq> existingFaqOptional = faqService.getFaqById(id);
		if (existingFaqOptional.isPresent()) {
			// FAQ exists, proceed with updating
			faq.setId(id); // Ensure the ID is set correctly
			faqService.updateFaq(faq);
			return new ResponseEntity<>("FAQ updated successfully", HttpStatus.OK);
		} else {
			// FAQ does not exist
			return new ResponseEntity<>("FAQ with ID " + id + " not found", HttpStatus.NOT_FOUND);
		}
	}

}
