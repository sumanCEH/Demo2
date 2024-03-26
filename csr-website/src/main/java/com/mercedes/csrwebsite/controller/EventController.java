package com.mercedes.csrwebsite.controller;
 
 

import com.mercedes.csrwebsite.model.Event;
import com.mercedes.csrwebsite.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.Optional;
 
// author = Lokesh
@RestController
@RequestMapping("/api/events")
public class EventController {
	@Autowired
    private  EventService eventService;
 
    @GetMapping("/getAllEvents")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
 
    /*@PostMapping("/createEvent")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }*/
    
    //author = Koushal
    // admin should only be allowed to create event
    @PostMapping("/createEvent")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }
    
    // admin only allowed for delete event
    
    
    //author = Lokesh
      @GetMapping("/event/{id}") public Optional<Event> getAllEvent(Long id) {
  	  return eventService.getEvent(id);
  	  
  	  }
  	  
      // normal users not allowed
  	  @GetMapping("/deleteEvent/{id}")  
  	  public void getDelEvent(Long id) {  
  		  eventService.deleteEvent(id);
  	  }
  	  
  	  //admin
  	  @PutMapping("/UpdateEvent/{id}") 
  	  public Event UpdateEvent(@RequestBody Event event) {  
  		  return eventService.updateEvent(event);
  	  }
}
 