package com.mercedes.csrwebsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercedes.csrwebsite.model.Feedback;
@Repository
public interface FeedbackDAO extends JpaRepository<Feedback, Long> {
	  
	Feedback findById(long id);

}
