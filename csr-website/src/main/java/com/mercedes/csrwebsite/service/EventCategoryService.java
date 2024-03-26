
package com.mercedes.csrwebsite.service;
 
 
import com.mercedes.csrwebsite.dao.EventCategoryDAO;
import com.mercedes.csrwebsite.model.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.Date;
import java.util.List;
 
@Service
public class EventCategoryService {
	@Autowired
    private EventCategoryDAO eventCategoryDAO;
 
 
    public List<EventCategory> getAllEventCategorys() {
        return eventCategoryDAO.findAll();
    }
 
    public EventCategory createEventCategory(EventCategory eventCategory) {
    	eventCategory.setCreatedAt(new Date());
    	eventCategory.setUpdatedAt(new Date());
    	//eventCategory.setDeleted(false);
 
        return eventCategoryDAO.save(eventCategory);
    }

	public EventCategory updateEventCategory(EventCategory eventCategory) {
		eventCategory.setCreatedAt(new Date());
    	eventCategory.setUpdatedAt(new Date());
		return eventCategoryDAO.save(eventCategory);
	}
 
 
}
 
