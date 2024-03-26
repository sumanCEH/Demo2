package com.mercedes.csrwebsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercedes.csrwebsite.model.Testimonial;
@Repository
public interface TestimonialDAO extends JpaRepository<Testimonial, Long> {
	  
	Testimonial findById(long id);
}

