package com.mercedes.csrwebsite.service;

import com.mercedes.csrwebsite.dao.SpocRepository;
import com.mercedes.csrwebsite.model.Spoc;
import com.mercedes.csrwebsite.service.SpocService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpocServiceTest {

    @Mock
    private SpocRepository spocRepository;

    @InjectMocks
    private SpocService spocService;

    @Test
    public void testGetAllSpocs() {
        // Mock the SpocRepository behavior
        when(spocRepository.findAll()).thenReturn(Collections.singletonList(new Spoc()));

        // Call the service method
        List<Spoc> spocs = spocService.getAllSpocs();

        // Verify the result
        assertEquals(1, spocs.size());
    }

    @Test
    public void testCreateSpoc() {
        // Create a Spoc object for testing
        Spoc spoc = new Spoc();
        spoc.setName("John Doe");
        // Set other properties as needed

        // Mock the SpocRepository behavior
        when(spocRepository.save(spoc)).thenReturn(spoc);

        // Call the service method
        Spoc createdSpoc = spocService.createSpoc(spoc);

        // Verify the result
        assertEquals("John Doe", createdSpoc.getName());
        // Add more assertions based on your Spoc object properties
    }

    /*@Test
    public void testGetSpocById() {
        // Mock the SpocRepository behavior
        when(spocRepository.findById(1L)).thenReturn(Optional.of(new Spoc()));

        // Call the service method
        Optional<Spoc> spoc = spocService.getSpocById(1L);

        // Verify the result
        assertEquals(true, spoc.isPresent());
    }*/

    // Add more test cases for other service methods as needed
}

