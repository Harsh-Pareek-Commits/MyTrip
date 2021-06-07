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
import com.g5.tms.entitydto.FeedbackEntityDto;
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
	
	
	/*
	 *Author= Jaydeep Maity
	 *Date= 26-May-2021
	 *Method name: addFeedback
	 *Parameters: FeedbackEntityDto object
	 *Return Type: FeedbackDto object
	 *
	 **/
	
	@ApiOperation(value = "Feedback Post mapping to add feedback", response = Feedback.class)
	@PostMapping("/add")
	public ResponseEntity<FeedbackDto> addFeedback(@RequestBody @Valid FeedbackEntityDto requestFeed) {
Feedback actualfeed = modelMapper.map(requestFeed, Feedback.class);
		FeedbackDto responsefeed = modelMapper.map(this.feedbackService.addFeedback(actualfeed), FeedbackDto.class);
		return new ResponseEntity<>(responsefeed, HttpStatus.OK);
	}
	
	/*
	 *Author= Jaydeep Maity
	 *Date= 26-May-2021
	 *Method name: viewFeedbackbyId
	 *Parameters: Feedback id
	 *Return Type: FeedbackDto object
	 *
	 **/
	
	@ApiOperation(value = "Feedback Get mapping to fetch feedback by feedback Id", response = Feedback.class)
	@GetMapping("/find/{feedid}")
	public ResponseEntity<FeedbackDto> viewFeedbackbyId(@PathVariable int feedid) throws FeedbackNotFoundException {

			FeedbackDto responsefeed = modelMapper.map(this.feedbackService.findByFeedbackId(feedid), FeedbackDto.class);
		if (responsefeed != null) {
			return new ResponseEntity<>(responsefeed, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsefeed, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	/*
	 *Author= Jaydeep Maity
	 *Date= 26-May-2021
	 *Method name: viewFeedbackbyCustomer
	 *Parameters: Customer id
	 *Return Type: FeedbackDto object
	 *
	 **/
	
	@ApiOperation(value = "Feedback Get mapping to fetch feedback by customer id", response = Feedback.class)
	@GetMapping("/find/customer/{custid}")
	public ResponseEntity<FeedbackDto> viewFeedbackbyCustomer(@PathVariable int custid) throws CustomerNotFoundException {

		FeedbackDto responsefeed = modelMapper.map(this.feedbackService.findByCustomerId(custid), FeedbackDto.class);
		if (responsefeed != null) {
			return new ResponseEntity<>(responsefeed, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsefeed, HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	 *Author= Jaydeep Maity
	 *Date= 26-May-2021
	 *Method name: viewAllFeedback
	 *Return Type: FeedbackDto object list
	 *
	 **/
	
	
	@ApiOperation(value = "Feedback Get mapping to fetch all feedbacks", response = List.class)
	@GetMapping("/find")
	public ResponseEntity<List<FeedbackDto>> viewAllFeedback() {
	       
	   List<Feedback> feedbackList = this.feedbackService.viewAllFeedbacks();
		List<FeedbackDto> feedbackDtoList = new ArrayList<>();
		for (Feedback f : feedbackList) {
			FeedbackDto feedbackdto = modelMapper.map(f, FeedbackDto.class);
			feedbackDtoList.add(feedbackdto);
		}
		if (!(feedbackDtoList.isEmpty())) {
			return new ResponseEntity<>(feedbackDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(feedbackDtoList, HttpStatus.BAD_REQUEST);
		}
	}

	

}
