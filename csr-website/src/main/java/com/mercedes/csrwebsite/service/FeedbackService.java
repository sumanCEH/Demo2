package com.mercedes.csrwebsite.service;
 
 
import com.mercedes.csrwebsite.dao.FeedbackDAO;
import com.mercedes.csrwebsite.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.Date;
import java.util.List;
import java.util.Optional;
 
@Service
public class FeedbackService {
	@Autowired
    private FeedbackDAO feedbackDAO;
 
 
    public List<Feedback> getAllFeedbacks() {
        return feedbackDAO.findAll();
    }
 
    public Feedback createFeedback(Feedback feedback) {
    	feedback.setUserid(new String());
    	feedback.setCreatedAt(new Date());
    	//feedback.setDeleted(false);
 
        return feedbackDAO.save(feedback);
    }
    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackDAO.findById(id);
    }
 
    public void deleteFeeback(Long id) {
         feedbackDAO.deleteById(id);
    }

	public Feedback updateFeedback(Feedback feedback) {
		feedback.setUserid(new String());
    	feedback.setCreatedAt(new Date());
    	//feedback.setDeleted(false);
 
        return feedbackDAO.save(feedback);
	}
 
 
}