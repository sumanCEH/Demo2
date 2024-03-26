package com.mercedes.csrwebsite.service;

import com.mercedes.csrwebsite.dao.FaqRepository;
import com.mercedes.csrwebsite.model.Faq;
import com.mercedes.csrwebsite.service.FaqService;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FaqServiceTest {

    @Mock
    private FaqRepository faqRepository;

    @InjectMocks
    private FaqService faqService;

    @Disabled
    @Test
    public void testGetAllFaqs() {
        // Mock the FaqRepository behavior
        when(faqRepository.findAll()).thenReturn(Collections.singletonList(new Faq()));

        // Call the service method
        List<Faq> faqs = faqService.getAllFaqs();

        // Verify the result
        assertEquals(1, faqs.size());
    }
    
    @Disabled
    @Test
    public void testCreateFaq() {
        // Create a Faq object for testing
        Faq faq = new Faq();
        faq.setQuestion("what is CSR portal all about ?");

        // Mock the FaqRepository behavior
        when(faqRepository.save(faq)).thenReturn(faq);

        // Call the service method
        Faq createdFaq = faqService.createFaq(faq);

        // Verify the result
        assertEquals("what is CSR portal all about ?", createdFaq.getQuestion());
        
        //The instanceof operator checks if the object on the left is an instance of the class on the right.
        assertEquals(true, createdFaq.getCreatedAt() instanceof Date);
        assertEquals(true, createdFaq.getUpdatedAt() instanceof Date);
        assertEquals(false, createdFaq.isDeleted());
    }

    @Disabled
    @Test
    public void testGetFaqById() {
        // Mock the FaqRepository behavior
        when(faqRepository.findById(1L)).thenReturn(Optional.of(new Faq()));

        // Call the service method
        Optional<Faq> faq = faqService.getFaqById(1L);

        // Verify the result
        assertEquals(true, faq.isPresent());
    }
    @Disabled
    @Test
    public void testDeleteFaq() {
        // Mock the FaqRepository behavior
        doNothing().when(faqRepository).deleteById(1L);

        // Call the service method
        faqService.deleteFaq(1L);

        // Verify that the deleteById method was called with the correct ID
        verify(faqRepository, times(1)).deleteById(1L);
    
    }
}

