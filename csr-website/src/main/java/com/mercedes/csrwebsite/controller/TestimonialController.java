package com.mercedes.csrwebsite.controller;
 
 
import com.mercedes.csrwebsite.model.Testimonial;
import com.mercedes.csrwebsite.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/Testimonial")
public class TestimonialController {
	@Autowired
    private  TestimonialService testimonialService;

 
	//optional
    @GetMapping("/getAllTestimonials")
    public List<Testimonial> getAllTestimonials() {
        return testimonialService.getAllTestimonials();
    }
 
    @PostMapping("/createTestimonial")
    public Testimonial createTestimonial(@RequestBody Testimonial testimonial) {
        return testimonialService.createTestimonial(testimonial);
    }
    
    @PutMapping("/updateTestimonial")
    public Testimonial updateTestimonial(@RequestBody Testimonial testimonial) {
        return testimonialService.updateTestimonial(testimonial);
    }
}
 