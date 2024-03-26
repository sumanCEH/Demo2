package com.mercedes.csrwebsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercedes.csrwebsite.model.UserImages;
@Repository
public interface UserImagesDAO extends JpaRepository<UserImages, Long> {
	  
	UserImages findById(long id);


}

