package com.g5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g5.entities.Feedback;
import com.g5.exceptions.CustomerNotFoundException;
import com.g5.exceptions.FeedbackNotFoundException;


public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {
	
	
		
	

}
