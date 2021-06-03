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
	IFeedbackRepository feedrepo;

	@Override
	@Transactional
	public Feedback addFeedback(Feedback feedback) {

		try {
			feedrepo.save(feedback);
		} catch (Exception e) {
			log.error("Add feedback Exception:", e);
		}
		return feedback;
	}

	@Override
	public Feedback findByFeedbackId(int feedbackId) throws FeedbackNotFoundException {
		Optional<Feedback> opt = feedrepo.findById(feedbackId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new FeedbackNotFoundException("Feedback not present whit this id");
		}

	}

	@Override
	public Feedback findByCustomerId(int customerId) throws CustomerNotFoundException {

		Optional<Feedback> opt = feedrepo.findbyCustId(customerId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new CustomerNotFoundException("Feedback not present for this customer id");
		}

	}

	@Override
	public List<Feedback> viewAllFeedbacks() {

		List<Feedback> feedbackList = null;
		try {

			feedbackList = feedrepo.findAll();

		} catch (Exception e) {

			log.error("view all feedback Exception:", e);
		}

		return feedbackList;
	}

}
