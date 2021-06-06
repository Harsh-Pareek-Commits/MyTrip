package com.g5.tms.dto;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BookingDto {

	private int bookingId;
	
	private String bookingType;

	private String description;
	
	private String bookingTitle;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingDate;
	
	private PackageDto pack;
	private PaymentDetailsDto payment;
	private TicketDetailsDto ticket;
	private int userId;
	
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

	public TicketDetailsDto getTicket() {
		return ticket;
	}

	public void setTicket(TicketDetailsDto ticket) {
		this.ticket = ticket;
	}
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BookingDto [bookingId=" + bookingId + ", bookingType=" + bookingType + ", description=" + description
				+ ", bookingTitle=" + bookingTitle + ", bookingDate=" + bookingDate + ", pack=" + pack + ", payment="
				+ payment + ", ticket=" + ticket + ", userId=" + userId + "]";
	}

	

}