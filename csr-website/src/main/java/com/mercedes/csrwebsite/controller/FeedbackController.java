package com.mercedes.csrwebsite.controller;
 
 
import com.mercedes.csrwebsite.model.Feedback;
import com.mercedes.csrwebsite.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.Optional;
 
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
	@Autowired
    private  FeedbackService feedbackService;
 
    @GetMapping("/getAllFeedbacks")
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }
 
    @PostMapping("/createFeedback")
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }
    
    @GetMapping("/feedback/{id}")
    public Optional<Feedback> getAllFeedback(Long id) {
        return feedbackService.getFeedbackById(id);
    }
    @GetMapping("/deletefeedback/{id}")
    public void getDelFeedback(Long id) {
         feedbackService.deleteFeeback(id);
    }
    @PutMapping("/updateFeedback")
    public Feedback updateFeedback(@RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(feedback);
    }
}
 