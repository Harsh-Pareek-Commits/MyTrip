package com.g5.tms.entitydto;

import java.time.LocalDate;


import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.g5.tms.entities.PaymentDetails;
import com.g5.tms.entities.TicketDetails;


public class BookingEntityDto {
	
	private int bookingId;
	@NotEmpty(message = "Booking Type cannot be left empty or null ")
	@Size(min = 3,message = "Invaid Booking Type")
	private String bookType;
	@Size(min = 3,max =50 ,message = "description should be min of 3 and max of 50 characters")
	private String bookDescription;
	@NotEmpty(message = "BookingTitle cannot be left blank or null")
	@Size(min = 5,max = 20, message = "Invalid Booking Title")
	private String bookTitle;
	@JsonFormat(pattern="yyyy-MM-dd")
	@FutureOrPresent(message="Date cannot be in Past")
	private LocalDate dateofBooking;
	@Valid
	private PackageEntityDto packDetails;
	@Positive
	private int userId;
	@Valid
	private PaymentDetails paymentDetails;
	@Valid
	private TicketDetails ticketDetails;
	
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public LocalDate getDateofBooking() {
		return dateofBooking;
	}
	public void setDateofBooking(LocalDate dateofBooking) {
		this.dateofBooking = dateofBooking;
	}

	
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public PackageEntityDto getPackDetails() {
		return packDetails;
	}
	public void setPackDetails(PackageEntityDto packDetails) {
		this.packDetails = packDetails;
	}
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public TicketDetails getTicketDetails() {
		return ticketDetails;
	}
	public void setTicketDetails(TicketDetails ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
	@Override
	public String toString() {
		return "BookingEntityDto [bookingId=" + bookingId + ", bookType=" + bookType + ", bookDescription="
				+ bookDescription + ", bookTitle=" + bookTitle + ", dateofBooking=" + dateofBooking + ", packDetails="
				+ packDetails + ", userId=" + userId + ", paymentDetails=" + paymentDetails + ", ticketDetails="
				+ ticketDetails + "]";
	}
	
}
