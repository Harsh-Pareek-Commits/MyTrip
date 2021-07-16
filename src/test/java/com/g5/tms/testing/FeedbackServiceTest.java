package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
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
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test3")
public class FeedbackServiceTest {
	
	@Autowired
	IFeedbackRepository feedRepository;
	@Autowired
	IFeedbackService feedService;
	
	
	@Test
	public void testAddFeedback() {
		Customer cust = new Customer("HARSH", "XYZ", "12312312312");
		cust.setUserType("3");
		cust.setUserId(1);
		LocalDate date = LocalDate.now();
		Feedback feed = new Feedback(1,cust,"good",3,date);
		Mockito.when(feedRepository.save(feed)).thenReturn(feed);
		Feedback result = feedService.addFeedback(feed);
		assertEquals(feed, result);
		
	}
	
	@Test
	public void testViewById() throws FeedbackNotFoundException {
		LocalDate date = LocalDate.now();
		Feedback feed = new Feedback(1, null, "good", 4, date);
		Optional<Feedback> opt = Optional.of(feed);
		Mockito.when(feedRepository.findById(1)).thenReturn(opt);
		Feedback test_feed = feedService.findByFeedbackId(1);
		assertEquals(feed, test_feed);
	}
	
	@Test
	public void testFeedbackByCustId() throws CustomerNotFoundException {
		
		Customer cust = new Customer("HARSH", "XYZ", "12312312312");
		cust.setUserType("3");
		cust.setUserId(1);
		LocalDate date = LocalDate.now();
		Feedback feed = new Feedback(1,cust,"good",3,date);
		Optional<Feedback> feed1 = Optional.of(feed);
		Mockito.when(feedRepository.findbyCustId(1)).thenReturn(feed1);
		Feedback test_feed = feedService.findByCustomerId(1);
		assertEquals(feed1.get(), test_feed);

	}
	
	@Test
	public void testViewAllFeedback() {
		
		LocalDate date = LocalDate.now();
		Feedback feed1 = new Feedback(1,null,"bad",1,date);
		Feedback feed = new Feedback(2, null, "good", 4, date);
		List<Feedback> feedback = Arrays.asList(feed1,feed);
		Mockito.when(feedRepository.findAll()).thenReturn(feedback);
		List<Feedback> actual_feedback = feedService.viewAllFeedbacks();
		assertEquals(feedback, actual_feedback);
	};
	
	@Test
	void testCustomerNotFoundException() {
		Customer customer = new Customer("HARSH", "XYZ", "12312312312");
		customer.setUserType("3");
		customer.setUserId(1);
		LocalDate date = LocalDate.now();
		Feedback feed = new Feedback(1,customer,"good",3,date);
		Optional<Feedback> feed1 = Optional.of(feed);
		when(feedRepository.findbyCustId(1)).thenReturn(feed1);
		Executable executable = ()->feedService.findByCustomerId(2);
		assertThrows(CustomerNotFoundException.class, executable);
	}
	
	@Test
	void testFeedbackNotFoundException() {
		Customer customer = new Customer("HARSH", "XYZ", "12312312312");
		customer.setUserType("3");
		customer.setUserId(2);
		LocalDate date = LocalDate.now();
		Feedback feed = new Feedback(1,customer,"good",3,date);
		Optional<Feedback> feed1 = Optional.of(feed);
		when(feedRepository.findById(1)).thenReturn(feed1);
		Executable executable = ()->feedService.findByFeedbackId(2);
		assertThrows(FeedbackNotFoundException.class, executable);
	}
	

}
