package com.mercedes.csrwebsite.service;

import com.mercedes.csrwebsite.dao.NotificationRepository;
import com.mercedes.csrwebsite.model.Notification;
import com.mercedes.csrwebsite.service.NotificationService;
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
public class NotificationServiceTest {

    @Mock
    private NotificationRepository notificationRepository;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    public void testGetAllNotifications() {
        // Mock the NotificationRepository behavior
        when(notificationRepository.findAll()).thenReturn(Collections.singletonList(new Notification()));

        // Call the service method
        List<Notification> notifications = notificationService.getAllNotifications();

        // Verify the result
        assertEquals(1, notifications.size());
    }

    @Test
    public void testCreateNotification() {
        // Create a Notification object for testing
        Notification notification = new Notification();
        notification.setEventId(1L);
        // Set other properties as needed

        // Mock the NotificationRepository behavior
        when(notificationRepository.save(notification)).thenReturn(notification);

        // Call the service method
        Notification createdNotification = notificationService.createNotification(notification);

        // Verify the result
        assertEquals(1L, createdNotification.getEventId());
        // Add more assertions based on your Notification object properties
    }

    /*@Test
    public void testGetNotificationById() {
        // Mock the NotificationRepository behavior
        when(notificationRepository.findById(1L)).thenReturn(Optional.of(new Notification()));

        // Call the service method
        Optional<Notification> notification = notificationService.getNotificationById(1L);

        // Verify the result
        assertEquals(true, notification.isPresent());
    }*/

    // Add more test cases for other service methods as needed
}
