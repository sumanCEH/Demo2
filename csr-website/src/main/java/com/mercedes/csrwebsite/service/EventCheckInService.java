package com.mercedes.csrwebsite.service;
 
 
import com.mercedes.csrwebsite.dao.EventCheckInDAO;
import com.mercedes.csrwebsite.model.EventCheckIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.Date;
import java.util.List;
 
@Service
public class EventCheckInService {
	@Autowired
    private  EventCheckInDAO eventCheckInDAO;

    public List<EventCheckIn> getAllEventCheckIns() {
        return eventCheckInDAO.findAll();
    }
 
    public EventCheckIn createEventCheckIn(EventCheckIn eventCheckIn) {
    	eventCheckIn.setCreatedAt(new Date());
    	eventCheckIn.setUpdatedAt(new Date());
        //event.setDeleted(false);
 
        return eventCheckInDAO.save(eventCheckIn);
    }

	public EventCheckIn updateEventCheckIn(EventCheckIn eventCheckIn) {
		eventCheckIn.setCreatedAt(new Date());
    	eventCheckIn.setUpdatedAt(new Date());
        //event.setDeleted(false);
 
        return eventCheckInDAO.save(eventCheckIn);
	}
 
 
}
 
