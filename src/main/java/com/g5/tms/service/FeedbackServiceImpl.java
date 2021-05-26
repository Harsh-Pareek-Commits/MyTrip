package com.g5.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g5.tms.entities.Feedback;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.FeedbackNotFoundException;
import com.g5.tms.repository.IFeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService  {
	
	@Autowired
	IFeedbackRepository feed_repo;

	@Override
	@Transactional
	public Feedback addFeedback(Feedback feedback) {
		
		try 
		{
			feed_repo.save(feedback);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return feedback;
	}

	@Override
	public Feedback findByFeedbackId(int feedbackId) throws FeedbackNotFoundException {
	
		try {
			return feed_repo.findById(feedbackId).get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new FeedbackNotFoundException("FeedbackId not found in find");
		}
	}

	@Override
	public Feedback findByCustomerId(int customerId) throws CustomerNotFoundException {
		Feedback feedback=null;
		try {
			feedback= feed_repo.findbyCustId(customerId);
		}
		catch (Exception e) {
		
		}
		return feedback;
	}

	@Override
	public List<Feedback> viewAllFeedbacks() {
		
		List<Feedback> feedbackList = null;
		try {
			
			feedbackList = feed_repo.findAll();
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	
		return feedbackList;
	}

	

}
