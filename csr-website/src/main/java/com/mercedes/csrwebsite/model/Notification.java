//Author : Koushal
package com.mercedes.csrwebsite.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "notification_text")
    private String notificationText;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

	
    // Constructors, getters, and setters
    
    public Notification() 
    {
	}


	public Notification(Long id, Long eventId, Long userId, String notificationText, String email, Date createdAt) {
		this.id = id;
		this.eventId = eventId;
		this.userId = userId;
		this.notificationText = notificationText;
		this.email = email;
		this.createdAt = createdAt;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getEventId() {
		return eventId;
	}


	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getNotificationText() {
		return notificationText;
	}


	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "Notification [id=" + id + ", eventId=" + eventId + ", userId=" + userId + ", notificationText="
				+ notificationText + ", email=" + email + ", createdAt=" + createdAt + "]";
	}
	
	
	

    
    
    
}

