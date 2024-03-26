package com.mercedes.csrwebsite.service;
 
 
import com.mercedes.csrwebsite.dao.TestimonialDAO;
import com.mercedes.csrwebsite.model.Testimonial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.Date;
import java.util.List;
 
@Service
public class TestimonialService {
	@Autowired
    private  TestimonialDAO testimonialDAO;

 
    public List<Testimonial> getAllTestimonials() {
        return testimonialDAO.findAll();
    }
 
    public Testimonial createTestimonial(Testimonial testimonial) {
    	testimonial.setCreatedAt(new Date());
    	testimonial.setUpdatedAt(new Date());
    	testimonial.setDeleted(false);
  
        return testimonialDAO.save(testimonial);
    }

	public Testimonial updateTestimonial(Testimonial testimonial) {
		return testimonialDAO.save(testimonial);
	}
 
 
}