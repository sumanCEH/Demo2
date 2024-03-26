//Author : Koushal
package com.mercedes.csrwebsite.dao;


import com.mercedes.csrwebsite.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Additional queries if needed
}
