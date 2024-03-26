//Author : Koushal
package com.mercedes.csrwebsite.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercedes.csrwebsite.dao.NotificationRepository;
import com.mercedes.csrwebsite.model.Notification;

//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class NotificationService {
	private final NotificationRepository notificationRepository;

	@Autowired
	public NotificationService(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	public List<Notification> getAllNotifications() {
		return notificationRepository.findAll();
	}

	public Notification createNotification(Notification notification) {
        // Set the createdAt field to the current system time before saving
        notification.setCreatedAt(new Date());
        return notificationRepository.save(notification);
    }

	public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

	public void updateNotification(Notification updatedNotification) {
		Optional<Notification> existingNotificationOptional = notificationRepository
				.findById(updatedNotification.getId());
		existingNotificationOptional.ifPresent(existingNotification -> {
			existingNotification.setEventId(updatedNotification.getEventId());
			existingNotification.setUserId(updatedNotification.getUserId());
			existingNotification.setNotificationText(updatedNotification.getNotificationText());
			existingNotification.setEmail(updatedNotification.getEmail());
			existingNotification.setCreatedAt(updatedNotification.getCreatedAt());
			// Update other fields as needed
			notificationRepository.save(existingNotification);
		});
	}

	public void deleteNotification(Long id) {
		notificationRepository.deleteById(id);
	}

}
