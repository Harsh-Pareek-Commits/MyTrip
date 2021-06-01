package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.g5.tms.entities.Customer;
import com.g5.tms.entities.Feedback;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.FeedbackNotFoundException;
import com.g5.tms.repository.IFeedbackRepository;
import com.g5.tms.service.IFeedbackService;

@SpringBootTest
@ActiveProfiles("test3")
public class FeedbackServiceTest {
	
	@Autowired
	IFeedbackRepository feed_repo;
	@Autowired
	IFeedbackService feed_serv;
	
	
	@Test
	public void testAddFeedback() {
		Customer cust = new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
		cust.setUserType("3");
		cust.setUserId(1);
		LocalDate date = LocalDate.now();
		Feedback feed = new Feedback(1,cust,"good",3,date);
		Mockito.when(feed_repo.save(feed)).thenReturn(feed);
		Feedback result = feed_serv.addFeedback(feed);
		assertEquals(feed, result);
		
	}
	
	@Test
	public void testViewById() throws FeedbackNotFoundException {
		LocalDate date = LocalDate.now();
		Feedback feed = new Feedback(1, null, "good", 4, date);
		Optional<Feedback> opt = Optional.of(feed);
		Mockito.when(feed_repo.findById(1)).thenReturn(opt);
		Feedback test_feed = feed_serv.findByFeedbackId(1);
		assertEquals(feed, test_feed);
	}
	
	@Test
	public void testFeedbackByCustId() throws CustomerNotFoundException {
		
		Customer cust = new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
		cust.setUserType("3");
		cust.setUserId(1);
		LocalDate date = LocalDate.now();
		Feedback feed = new Feedback(1,cust,"good",3,date);
		Optional<Feedback> feed1 = Optional.of(feed);
		Mockito.when(feed_repo.findbyCustId(1)).thenReturn(feed1);
		Feedback test_feed = feed_serv.findByCustomerId(1);
		assertEquals(feed1.get(), test_feed);

	}
	
	@Test
	public void testViewAllFeedback() {
		
		LocalDate date = LocalDate.now();
		Feedback feed1 = new Feedback(1,null,"bad",1,date);
		Feedback feed = new Feedback(2, null, "good", 4, date);
		List<Feedback> feedback = Arrays.asList(feed1,feed);
		Mockito.when(feed_repo.findAll()).thenReturn(feedback);
		List<Feedback> actual_feedback = feed_serv.viewAllFeedbacks();
		assertEquals(feedback, actual_feedback);
	};
	
	

}
