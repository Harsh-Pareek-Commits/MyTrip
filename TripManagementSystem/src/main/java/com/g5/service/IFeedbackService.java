package com.g5.service;


import java.util.List;

import com.g5.entities.Feedback;
import com.g5.exceptions.CustomerNotFoundException;
import com.g5.exceptions.FeedbackNotFoundException;


public interface IFeedbackService {
	
	
		public Feedback  addFeedback(Feedback feedback);
		public Feedback   findByFeedbackId(int feedbackId) throws FeedbackNotFoundException;
		public Feedback   findByCustomerId(int customerId) throws CustomerNotFoundException;
		public List<Feedback> viewAllFeedbacks();
	
	

}
