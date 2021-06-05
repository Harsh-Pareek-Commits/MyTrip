package com.g5.tms.entities;

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

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_info", referencedColumnName = "userId")
	@Valid
	private Customer customer;
	@Column
	@Size(min = 2,max = 50,message = "feedback should be min of 2 and max of 50 characters")
	private String feedback;
	@Column
	@Min(value = 1, message = "Rating should not be less than 1")
    @Max(value = 5, message = "Rating should not be greater than 5")
	private int rating;
	@FutureOrPresent(message="date can't be in past")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate submitDate;

	public Feedback() {
		super();

	}

	public Feedback(int feedbackId, Customer customer, String feedback, int rating, LocalDate submitDate) {
		super();
		this.feedbackId = feedbackId;
		this.customer = customer;
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
	}

	/**
	 * @return the feedbackId
	 */
	public int getFeedbackId() {
		return feedbackId;
	}

	/**
	 * @param feedbackId2 the feedbackId to set
	 */
	public void setFeedbackId(int feedbackId2) {
		this.feedbackId = feedbackId2;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}

	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the submitDate
	 */
	public LocalDate getSubmitDate() {
		return submitDate;
	}

	/**
	 * @param submitDate the submitDate to set
	 */
	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
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

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", customer=" + customer + ", feedback=" + feedback + ", rating="
				+ rating + ", submitDate=" + submitDate + "]";
	}

}
