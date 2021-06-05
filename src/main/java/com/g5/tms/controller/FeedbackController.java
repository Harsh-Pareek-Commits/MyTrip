package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.dto.FeedbackDto;
import com.g5.tms.entities.Feedback;
import com.g5.tms.entityDto.FeedbackEntityDto;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.FeedbackNotFoundException;
import com.g5.tms.service.IFeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	IFeedbackService feedbackService;
	@Autowired
	private ModelMapper modelMapper;
	

	@PostMapping("/add")
	public ResponseEntity<FeedbackDto> addFeedback(@RequestBody @Valid FeedbackEntityDto requestFeed) {

		Feedback actualfeed = modelMapper.map(requestFeed, Feedback.class);
		FeedbackDto responsefeed = modelMapper.map(this.feedbackService.addFeedback(actualfeed), FeedbackDto.class);
		return new ResponseEntity<>(responsefeed, HttpStatus.OK);
	}
	/*public Feedback addFeedback(@RequestBody @Valid Feedback feed) {
		this.feedbackService.addFeedback(feed);
		return feed;
	}*/
	
	@GetMapping("/find/{feedbackId}")
	public ResponseEntity<FeedbackDto> viewFeedbackbyId(@PathVariable int feedid) throws FeedbackNotFoundException {

		FeedbackDto responsefeed = modelMapper.map(this.feedbackService.findByFeedbackId(feedid), FeedbackDto.class);
		if (responsefeed != null) {
			return new ResponseEntity<>(responsefeed, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsefeed, HttpStatus.BAD_REQUEST);
		}
	}
	
	/*public Feedback findByFeedbackId(@PathVariable int feedbackId) throws FeedbackNotFoundException {
    	Feedback feed = this.feedbackService.findByFeedbackId(feedbackId);
		return feed;
	}*/
	
	@GetMapping("/find/customer/{customerId}")
	public ResponseEntity<FeedbackDto> viewFeedbackbyCustomer(@PathVariable int custid) throws CustomerNotFoundException {

		FeedbackDto responsefeed = modelMapper.map(this.feedbackService.findByCustomerId(custid), FeedbackDto.class);
		if (responsefeed != null) {
			return new ResponseEntity<>(responsefeed, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsefeed, HttpStatus.BAD_REQUEST);
		}
	}
	
	/*public Feedback findByCustomerId(@PathVariable int customerId) throws CustomerNotFoundException {
    	Feedback feed = this.feedbackService.findByCustomerId(customerId);
		return feed;
	}*/
	
	@GetMapping("/find")
	
	public ResponseEntity<List<FeedbackDto>> viewAllFeedback() {
	       
        List<Feedback> FeedbackList = this.feedbackService.viewAllFeedbacks();
		List<FeedbackDto> FeedbackDtoList = new ArrayList<>();
		for (Feedback f : FeedbackList) {
			FeedbackDto feedbackdto = modelMapper.map(f, FeedbackDto.class);
			FeedbackDtoList.add(feedbackdto);
		}
		if (!(FeedbackDtoList.isEmpty())) {
			return new ResponseEntity<>(FeedbackDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(FeedbackDtoList, HttpStatus.BAD_REQUEST);
		}
	}
	/*public List< @NotEmpty Feedback> viewAllFeedbacks() {
		return feedbackService.viewAllFeedbacks();
		
	}*/
	

}
