package com.mercedes.csrwebsite.controller;
 
 
import com.mercedes.csrwebsite.model.EventCheckIn;
import com.mercedes.csrwebsite.service.EventCheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
//Author =Lokesh
@RestController
@RequestMapping("/api/eventCheckIn")
public class EventCheckInController {
	@Autowired
    private EventCheckInService eventCheckInService;

 
    @GetMapping("/getAllEventCheckIns")
    public List<EventCheckIn> getAllEventCheckIns() {
        return eventCheckInService.getAllEventCheckIns();
    }
 
    @PostMapping("/createEventCheckIn")
    public EventCheckIn createEventCheckIn(@RequestBody EventCheckIn eventCheckIn) {
        return eventCheckInService.createEventCheckIn(eventCheckIn);
    }
    
    //optional
    @PutMapping("/updateEventCheckIn")
    public EventCheckIn updateEventCheckIn(@RequestBody EventCheckIn eventCheckIn) {
        return eventCheckInService.updateEventCheckIn(eventCheckIn);
    }
    
    // Delete Event
}
 