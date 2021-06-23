package com.g5.tms.dto;

import java.time.LocalDate;




import com.fasterxml.jackson.annotation.JsonFormat;
import com.g5.tms.entities.Customer;

import lombok.Data;

@Data
public class FeedbackDto {

	
	private int feedbackId;
	
	private CustomerDto customer;

	private String feedback;
	
	private int rating;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate submitDate;
	 
	private PackageDto pack;

	public PackageDto getPack() {
		return pack;
	}

	public void setPack(PackageDto pack) {
		this.pack = pack;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "FeedbackDto [feedbackId=" + feedbackId + ", customer=" + customer + ", feedback=" + feedback
				+ ", rating=" + rating + ", submitDate=" + submitDate + ", pack=" + pack + "]";
	}
	

	

}