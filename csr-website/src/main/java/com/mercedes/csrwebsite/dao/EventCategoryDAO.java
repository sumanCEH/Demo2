package com.mercedes.csrwebsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercedes.csrwebsite.model.EventCategory;

@Repository
public interface EventCategoryDAO extends JpaRepository<EventCategory, Long> {
	  
	EventCategory findById(long id);
}
