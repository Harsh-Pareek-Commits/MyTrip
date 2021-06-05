package com.g5.tms.entityDto;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


public class FeedbackEntityDto {


	private int feedbackId;
	@Valid
	private CustomerEntityDto customer;
	@Size(min = 2,max = 50,message = "feedback should be min of 2 and max of 50 characters")
	private String feedback;
	@Min(value = 1, message = "Rating should not be less than 1")
    @Max(value = 5, message = "Rating should not be greater than 5")
	private int rating;
	@FutureOrPresent(message="date can't be in past")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate submitDate;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public CustomerEntityDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntityDto customer) {
		this.customer = customer;
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

	@Override
	public String toString() {
		return "FeedbackEntityDto [feedbackId=" + feedbackId + ", customer=" + customer + ", feedback=" + feedback
				+ ", rating=" + rating + ", submitDate=" + submitDate + "]";
	}

	

}
