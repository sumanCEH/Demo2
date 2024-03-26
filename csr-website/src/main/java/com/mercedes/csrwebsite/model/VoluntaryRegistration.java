//Author : Koushal
package com.mercedes.csrwebsite.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class VoluntaryRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "event_id")
    private Long eventId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

	

    // Other fields and constructors, getters, setters as needed
    
    public VoluntaryRegistration() 
	{
	}



	public VoluntaryRegistration(Long id, Long userId, Long eventId, Date createdAt) {
		this.id = id;
		this.userId = userId;
		this.eventId = eventId;
		this.createdAt = createdAt;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public Long getEventId() {
		return eventId;
	}



	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	@Override
	public String toString() {
		return "VoluntaryRegistration [id=" + id + ", userId=" + userId + ", eventId=" + eventId + ", createdAt="
				+ createdAt + "]";
	}
    
    
    
    
}

