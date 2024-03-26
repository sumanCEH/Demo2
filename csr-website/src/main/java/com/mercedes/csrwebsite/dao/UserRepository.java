//Author : Koushal
package com.mercedes.csrwebsite.dao;

import com.mercedes.csrwebsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> 
{
    // Additional queries if needed
	// to find user by email
	//User findByEmail(String email); 
	//User findByUsername(String username);
}

