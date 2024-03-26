package com.mercedes.csrwebsite.service;

import com.mercedes.csrwebsite.dao.UserRepository;
import com.mercedes.csrwebsite.model.User;
import com.mercedes.csrwebsite.service.UserService;
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
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks	
    private UserService userService;

    @Test
    public void testGetAllUsers() {
        // Mock the UserRepository behavior
        when(userRepository.findAll()).thenReturn(Collections.singletonList(new User()));

        // Call the service method
        List<User> users = userService.getAllUsers();

        // Verify the result
        assertEquals(1, users.size());
    }

    @Test
    public void testCreateUser() {
        // Create a user object for testing
        User user = new User();
        user.setName("Koushal Sharma");

        // Mock the UserRepository behavior
        when(userRepository.save(user)).thenReturn(user);

        // Call the service method
        User createdUser = userService.createUser(user);

        // Verify the result
        assertEquals("Koushal Sharma", createdUser.getName());
    }

    /*@Test
    public void testGetUserById() {
        // Mock the UserRepository behavior
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User()));

        // Call the service method
        Optional<User> user = userService.getUserById(1L);

        // Verify the result
        assertEquals(true, user.isPresent());
    } */ 

    // Add more test cases for other service methods as needed
}

