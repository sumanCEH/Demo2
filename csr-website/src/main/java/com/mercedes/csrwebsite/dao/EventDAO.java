package com.mercedes.csrwebsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercedes.csrwebsite.model.Event;

@Repository
public interface EventDAO extends JpaRepository<Event, Long> {
  
	Event findById(long id);

}

