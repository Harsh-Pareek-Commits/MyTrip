package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/feedback")
@Api("Travel Management Application")
public class FeedbackController {
	@Autowired
	IFeedbackService feedbackService;
	@Autowired
	private ModelMapper modelMapper;
	
	Logger log = LoggerFactory.getLogger(FeedbackController.class);

	
	@ApiOperation(value = "Feedback Post mapping to add feedback", response = Feedback.class)
	@PostMapping("/add")
	public ResponseEntity<FeedbackDto> addFeedback(@RequestBody @Valid FeedbackEntityDto requestFeed) {

		log.info("Inside add feedback");
		Feedback actualfeed = modelMapper.map(requestFeed, Feedback.class);
		FeedbackDto responsefeed = modelMapper.map(this.feedbackService.addFeedback(actualfeed), FeedbackDto.class);
		return new ResponseEntity<>(responsefeed, HttpStatus.OK);
	}
	/*public Feedback addFeedback(@RequestBody @Valid Feedback feed) {
		this.feedbackService.addFeedback(feed);
		return feed;
	}*/
	
	@ApiOperation(value = "Feedback Get mapping to fetch feedback by feedback Id", response = Feedback.class)
	@GetMapping("/find/{feedid}")
	public ResponseEntity<FeedbackDto> viewFeedbackbyId(@PathVariable int feedid) throws FeedbackNotFoundException {

		log.info("Inside finding feedback by feedback id");
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
	
	@ApiOperation(value = "Feedback Get mapping to fetch feedback by customer id", response = Feedback.class)
	@GetMapping("/find/customer/{custid}")
	public ResponseEntity<FeedbackDto> viewFeedbackbyCustomer(@PathVariable int custid) throws CustomerNotFoundException {

		log.info("Inside finding feedback using customer id");
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
	
	
	@ApiOperation(value = "Feedback Get mapping to fetch all feedbacks", response = List.class)
	@GetMapping("/find")
	public ResponseEntity<List<FeedbackDto>> viewAllFeedback() {
	       
		log.info("Inside get all feedbacks");
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
