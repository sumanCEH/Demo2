//Author : Koushal
package com.mercedes.csrwebsite.service;

import com.mercedes.csrwebsite.dao.FaqRepository;
import com.mercedes.csrwebsite.model.Faq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FaqService {
	private final FaqRepository faqRepository;

	@Autowired
	public FaqService(FaqRepository faqRepository) {
		this.faqRepository = faqRepository;
	}

//	public List<Faq> getAllFaqs() {
//		return faqRepository.findAll();
//	}
	
	public List<Faq> getAllFaqs() {
        return faqRepository.findByDeletedFalse();
    }

	public Optional<Faq> getFaqById(Long id) {
		return faqRepository.findById(id);
	}

	public Faq createFaq(Faq faq) {
		faq.setCreatedAt(new Date()); /*
										 * used to track when the fields were created updated, or deleted
										 */
		faq.setUpdatedAt(new Date());
		faq.setDeleted(false);

		// Additional business logic or validation can be added here before saving to
		// the database
		return faqRepository.save(faq);
	}

	public void deleteFaq(Long id) {
		/*
		 * faqRepository.deleteById(id); if we do this then the faq will be directly
		 * removed from the database, which is hard deleted, instead we should do soft
		 * delete
		 */

		Optional<Faq> optionalFaq = faqRepository.findById(id);

		if (optionalFaq.isPresent()) {
			Faq faq = optionalFaq.get();
			faq.setDeleted(true);
			faqRepository.save(faq);
		} else {
			// Handle the case where the FAQ with the specified ID is not found
			// You can throw an exception or handle it according to your business logic
		}
	}

	public void updateFaq(Faq faq) {
		Optional<Faq> existingFaqOptional = faqRepository.findById(faq.getId());
		if (existingFaqOptional.isPresent()) {
			Faq existingFaq = existingFaqOptional.get();
			existingFaq.setQuestion(faq.getQuestion());
			existingFaq.setAnswer(faq.getAnswer());
			existingFaq.setUpdatedAt(new Date());
			// Additional fields to update if needed
			faqRepository.save(existingFaq);
		} else {
			// Handle the case where the FAQ with the specified ID is not found
			// You can throw an exception or handle it according to your business logic
		}
	}

	// Other methods for updating FAQs if needed
}
