package com.g5.tms.entities;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_info", referencedColumnName = "userId")
	@Valid
	private Customer customer;
	
	@ApiModelProperty(name = "Feedback", value = "Holds min of 2 and max of 50 characters")
	@Column
	@Size(min = 2,max = 50,message = "feedback should be min of 2 and max of 50 characters")
	private String feedback;
	
	@ApiModelProperty(name = "Rating", value = "Rating can only be in between 1 to 5")
	@Column
	@Min(value = 1, message = "Rating should not be less than 1")
    @Max(value = 5, message = "Rating should not be greater than 5")
	private int rating;
	
	@ApiModelProperty(name = "SubmitDate", value = "Date cannot be past")
	@FutureOrPresent(message="date can't be in past")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate submitDate;
	
	@ApiModelProperty(name = "Package", value = "Contains package information")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "package_info", referencedColumnName = "packageId")
	@Valid
	private Package pack;
	

	public Feedback() {
		super();

	}


	public Feedback(int feedbackId, @Valid Customer customer,
			@Size(min = 2, max = 50, message = "feedback should be min of 2 and max of 50 characters") String feedback,
			@Min(value = 1, message = "Rating should not be less than 1") @Max(value = 5, message = "Rating should not be greater than 5") int rating,
			@FutureOrPresent(message = "date can't be in past") LocalDate submitDate, @Valid Package pack) {
		super();
		this.feedbackId = feedbackId;
		this.customer = customer;
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
		this.pack = pack;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + feedbackId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		if (feedbackId != other.feedbackId)
			return false;
		return true;
	}


	public int getFeedbackId() {
		return feedbackId;
	}


	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
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


	public Package getPack() {
		return pack;
	}


	public void setPack(Package pack) {
		this.pack = pack;
	}


	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", customer=" + customer + ", feedback=" + feedback + ", rating="
				+ rating + ", submitDate=" + submitDate + ", pack=" + pack + "]";
	}
	
}

	