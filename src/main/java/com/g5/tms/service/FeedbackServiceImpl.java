package com.g5.tms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g5.tms.entities.Feedback;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.FeedbackNotFoundException;
import com.g5.tms.repository.IFeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
	Logger log = LoggerFactory.getLogger(FeedbackServiceImpl.class);
	@Autowired
	IFeedbackRepository feedbackRepository;
	
	/*
	 *Author= Jaydeep Maity
	 *Date= 24-May-2021
	 *Method name: addFeedback
	 *Parameters: Feedback object
	 *Return Type: Feedback object
	 *
	 **/
	@Override
	@Transactional
	public Feedback addFeedback(Feedback feedback) {

		try {
			feedbackRepository.save(feedback);
		} catch (Exception e) {
			log.error("Add feedback Exception:", e);
		}
		return feedback;
	}
	
	/*
	 *Author= Jaydeep Maity
	 *Date= 24-May-2021
	 *Method name: findByFeedbackId
	 *Parameters: Feedback id
	 *Return Type: Feedback object
	 *
	 **/

	@Override
	public Feedback findByFeedbackId(int feedbackId) throws FeedbackNotFoundException {
		try {
			Optional<Feedback> opt = feedbackRepository.findById(feedbackId);
			if (opt.isPresent()) {
				return opt.get();
			} else {
				throw new FeedbackNotFoundException("Feedback not present with this id");
			}
		} catch (Exception e) {
			throw new FeedbackNotFoundException("Feedback not found ");
		}

	}
	
	
	/*
	 *Author= Jaydeep Maity
	 *Date= 24-May-2021
	 *Method name: findByCustomerId
	 *Parameters: Customer id 
	 *Return Type: Feedback object
	 *
	 **/

	@Override
	public Feedback findByCustomerId(int customerId) throws CustomerNotFoundException {
		try {
			Optional<Feedback> opt = feedbackRepository.findbyCustId(customerId);
			if (opt.isPresent()) {
				return opt.get();
			} else {
				throw new CustomerNotFoundException("Feedback not present for this customer id");
			}
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer not found");
		}
	}
	
	/*
	 *Author= Jaydeep Maity
	 *Date= 24-May-2021
	 *Method name: viewallFeedbacks
	 *Return Type: Feedback object List
	 *
	 **/

	@Override
	public List<Feedback> viewAllFeedbacks() {

		List<Feedback> feedbackList = null;
		try {

			feedbackList = feedbackRepository.findAll();

		} catch (Exception e) {

			log.error("view all feedback Exception:", e);
		}

		return feedbackList;
	}

}
