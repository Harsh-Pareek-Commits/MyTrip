package com.g5.tms.entitydto;

import java.time.LocalDate;



import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


public class FeedbackEntityDto {

	@Valid
	private CustomerEntityDto customer;
	@Size(min = 2,max = 50,message = "feedback should be min of 2 and max of 50 characters")
	private String feedbackInfo;
	@Min(value = 1, message = "Rating should not be less than 1")
    @Max(value = 5, message = "Rating should not be greater than 5")
	private int feedbackRating;
	@FutureOrPresent(message="date can't be in past")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate submitDate;
	
	public String getFeedbackInfo() {
		return feedbackInfo;
	}
	public void setFeedbackInfo(String feedbackInfo) {
		this.feedbackInfo = feedbackInfo;
	}
	public int getFeedbackRating() {
		return feedbackRating;
	}
	public void setFeedbackRating(int feedbackRating) {
		this.feedbackRating = feedbackRating;
	}
	public CustomerEntityDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntityDto customer) {
		this.customer = customer;
	}
	public LocalDate getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}
	@Override
	public String toString() {
		return "FeedbackEntityDto [customer=" + customer + ", feedbackInfo=" + feedbackInfo + ", feedbackRating="
				+ feedbackRating + ", submitDate=" + submitDate + "]";
	}
	
}
