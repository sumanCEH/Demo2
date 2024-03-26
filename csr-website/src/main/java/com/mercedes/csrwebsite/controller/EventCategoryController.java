package com.mercedes.csrwebsite.controller;
 
 
import com.mercedes.csrwebsite.model.EventCategory;
import com.mercedes.csrwebsite.service.EventCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
//Author = Lokesh 
@RestController
@RequestMapping("/api/eventCategory")
public class EventCategoryController {
	@Autowired
    private EventCategoryService eventCategoryService;
 
    @GetMapping("/getAllEventCategorys")
    public List<EventCategory> getAllEventCategorys() {
        return eventCategoryService.getAllEventCategorys();
    }
 
    @PostMapping("/CreateEventCategory")
    public EventCategory createEventCategory(@RequestBody EventCategory eventCategory) {
        return eventCategoryService.createEventCategory(eventCategory);
    }
    @PutMapping("/UpdateEventCategory")
    public EventCategory updateEventCategory(@RequestBody EventCategory eventCategory) {
        return eventCategoryService.updateEventCategory(eventCategory);
    }
 
}
 