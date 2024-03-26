package com.mercedes.csrwebsite.service;
 
 
import com.mercedes.csrwebsite.dao.EventDAO;
import com.mercedes.csrwebsite.model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;
 
@Service
public class EventService {
	@Autowired
    private EventDAO eventDAO;
 
	
    public List<Event> getAllEvents() {
        return eventDAO.findAll();
    }
  
    
    public Event createEvent(Event event) {
        event.setCreatedAt(new Date());
        event.setUpdatedAt(new Date());
        event.setDeleted(false);
        Event updatedevent= eventDAO.save(event);
        return updatedevent;
    }
    
    
    public Optional<Event> getEvent(Long id) {
        return eventDAO.findById(id);
    }
    
    
    public void deleteEvent(Long id) {
         eventDAO.deleteById(id);
    }
 
    public Event updateEvent(Event event) {  
    	event.setCreatedAt(new Date());
        event.setUpdatedAt(new Date());
        event.setDeleted(false);
		  return eventDAO.save(event);
	  }
}
 
