package com.g5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.g5.entities.Feedback;
import com.g5.exceptions.CustomerNotFoundException;
import com.g5.exceptions.FeedbackNotFoundException;
import com.g5.repository.IFeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService  {
	
	@Autowired
	IFeedbackRepository feed;

	@Override
	@Transactional
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		try 
		{
			feed.save(feedback);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return feedback;
	}

	@Override
	public Feedback findByFeedbackId(int feedbackId) throws FeedbackNotFoundException {
		// TODO Auto-generated method stub
		try {
			return feed.findById(feedbackId).get();
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
			feedback= feed.findbyCustId(customerId);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return feedback;
	}

	@Override
	public List<Feedback> viewAllFeedbacks() {
		
		List<Feedback> feedbackList = null;
		try {
			
			feedbackList = feed.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return feedbackList;
	}

	

}
