//Author : Koushal
package com.mercedes.csrwebsite.controller;

import com.mercedes.csrwebsite.model.Notification;
import com.mercedes.csrwebsite.service.NotificationService;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
	private final NotificationService notificationService;

	@Autowired
	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	 @GetMapping("/getAllNotifications")
	    public ResponseEntity<?> getAllNotifications() {
	        List<Notification> notifications = notificationService.getAllNotifications();
	        if (notifications.isEmpty()) {
	            return ResponseEntity.ok("No notifications as of now");
	        } else {
	            return ResponseEntity.ok(notifications);
	        }
	    }

	@PostMapping("/createNotification")
	public Notification createNotification(@RequestBody Notification notification) {
		return notificationService.createNotification(notification);
	}

	// Other controller methods for updating and deleting Notifications if needed

	@GetMapping("/{id}")
	public ResponseEntity<?> getNotificationById(@PathVariable Long id) {
	    Optional<Notification> notificationOptional = notificationService.getNotificationById(id);
	    if (notificationOptional.isPresent()) {
	        return new ResponseEntity<>(notificationOptional.get(), HttpStatus.OK);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            .body("Notification with ID " + id + " doesn't exist");
	    }
	}

	
	

	 @PutMapping("/updateNotification/{id}")
	    public ResponseEntity<String> updateNotification(@PathVariable Long id, @RequestBody Notification updatedNotification) {
	        Optional<Notification> existingNotificationOptional = notificationService.getNotificationById(id);
	        if (existingNotificationOptional.isPresent()) {
	            updatedNotification.setId(id); // Ensure the ID is set correctly
	            notificationService.updateNotification(updatedNotification);
	            return ResponseEntity.ok("Notification updated successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notification with ID " + id + " not found");
	        }
	    }

	@DeleteMapping("/deleteNotification/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id) {
        Optional<Notification> notificationOptional = notificationService.getNotificationById(id);
        if (notificationOptional.isPresent()) {
            notificationService.deleteNotification(id);
            return ResponseEntity.ok("Notification deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notification with ID " + id + " not found");
        }
    }
}
