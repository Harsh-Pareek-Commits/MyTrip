package com.g5.tms.dto;

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

import com.g5.tms.entities.Package;
import com.g5.tms.entities.PaymentDetails;
import com.g5.tms.entities.TicketDetails;

import lombok.Data;

@Data
public class BookingDto {

	private int bookingId;
	
	private String bookingType;

	private String description;
	
	private String bookingTitle;
	
	private LocalDate bookingDate;
	
	private PackageDto pack;
	private PaymentDetailsDto payment;
	private TicketDetailsDTo ticket;
	
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

	public PackageDto getPack() {
		return pack;
	}

	public void setPack(PackageDto pack) {
		this.pack = pack;
	}

	public PaymentDetailsDto getPayment() {
		return payment;
	}

	public void setPayment(PaymentDetailsDto payment) {
		this.payment = payment;
	}

	public TicketDetailsDTo getTicket() {
		return ticket;
	}

	public void setTicket(TicketDetailsDTo ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "BookingDto [bookingId=" + bookingId + ", bookingType=" + bookingType + ", description=" + description
				+ ", bookingTitle=" + bookingTitle + ", bookingDate=" + bookingDate + ", pack=" + pack + "]";
	}
	

}