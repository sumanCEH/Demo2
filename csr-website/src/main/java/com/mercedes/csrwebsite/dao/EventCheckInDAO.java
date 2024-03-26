package com.mercedes.csrwebsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercedes.csrwebsite.model.EventCheckIn;

@Repository
public interface EventCheckInDAO extends JpaRepository<EventCheckIn, Long> {
  
	EventCheckIn findById(long id);
}