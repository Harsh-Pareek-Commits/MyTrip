package com.g5.tms.entityDto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.g5.tms.entities.PaymentDetails;
import com.g5.tms.entities.TicketDetails;


public class BookingEntityDto {
	
	private int bookingId;
	
	private String bookingType;
	
	private String description;
	
	private String bookingTitle;
	
	private LocalDate bookingDate;
	
	private PackageEntityDto pack;
	
	private int userId;
	
	private PaymentDetails payment;
	
	private TicketDetails ticket;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookingTitle() {
		return bookingTitle;
	}

	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public PackageEntityDto getPack() {
		return pack;
	}

	public void setPack(PackageEntityDto pack) {
		this.pack = pack;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public PaymentDetails getPayment() {
		return payment;
	}

	public void setPayment(PaymentDetails payment) {
		this.payment = payment;
	}

	public TicketDetails getTicket() {
		return ticket;
	}

	public void setTicket(TicketDetails ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "BookingEntityDto [bookingId=" + bookingId + ", bookingType=" + bookingType + ", description="
				+ description + ", bookingTitle=" + bookingTitle + ", bookingDate=" + bookingDate + ", pack=" + pack
				+ ", userId=" + userId + ", payment=" + payment + ", ticket=" + ticket + "]";
	}

	
}
