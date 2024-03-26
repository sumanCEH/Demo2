//Author : Koushal
package com.mercedes.csrwebsite.dao;


import com.mercedes.csrwebsite.model.Faq;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FaqRepository extends JpaRepository<Faq, Long> 
{
    // Additional queries if needed
	@Query(value = "SELECT * FROM faq WHERE is_deleted = false", nativeQuery = true)
    List<Faq> findByDeletedFalse();
}
