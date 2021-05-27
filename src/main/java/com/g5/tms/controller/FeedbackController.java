package com.g5.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.g5.tms.entities.Feedback;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.FeedbackNotFoundException;
import com.g5.tms.service.IFeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
IFeedbackService feedback_service;
	

	@PostMapping("/add")
	public Feedback addFeedback(@RequestBody Feedback feed) {
		this.feedback_service.addFeedback(feed);
		return feed;
	}
	
	@GetMapping("/find/{feedbackId}")
	public Feedback findByFeedbackId(@PathVariable int feedbackId) throws FeedbackNotFoundException {
    	Feedback feed = this.feedback_service.findByFeedbackId(feedbackId);
		return feed;
	}
	
	@GetMapping("/find/customer/{customerId}")
	public Feedback findByCustomerId(@PathVariable int customerId) throws CustomerNotFoundException {
    	Feedback feed = this.feedback_service.findByCustomerId(customerId);
		return feed;
	}
	
	@GetMapping("/find")
	public List<Feedback> viewAllFeedbacks() {
		return feedback_service.viewAllFeedbacks();
		
	}
	

}
