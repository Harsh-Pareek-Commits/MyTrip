package com.g5.tms.entities;

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

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	@ApiModelProperty(name = "BookingType", value = "Holds the min 3 characters")
	@Column
	@NotEmpty(message = "Booking Type cannot be left empty or null ")
	private String bookingType;
	
	@ApiModelProperty(name = "Description", value = "Holds the min 3 characters and max of 50 characters")
	@Column
	private String description;
	
	@ApiModelProperty(name = "BookingTitle", value = "Cannot be null, holds the min 5 characters and max of 20 characters ")
	@Column
	@NotEmpty(message = "BookingTitle cannot be left blank or null")
	private String bookingTitle;
	
	@ApiModelProperty(name = "BookingDate", value = "Date cannot be past")
	@FutureOrPresent(message="Date cannot be in Past")
	private LocalDate bookingDate;
	
	
	@ApiModelProperty(name = "Package", value = "Contains package information")
	@OneToOne
	@JoinColumn(name = "Package_info", referencedColumnName = "packageId")
	@Valid
	private Package pack;
	
	@ApiModelProperty(name = "UserId", value = "Contains positive digit user id")
	@Column
	@Positive
	private int userId;
	
	@ApiModelProperty(name = "Payment", value = "Contains payment details")
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Payment_info", referencedColumnName = "paymentId")
	@Valid
	private PaymentDetails payment;
	
	@ApiModelProperty(name = "Ticket", value = "Contains TicketDetails")
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Ticket_info", referencedColumnName = "ticketId")
	@Valid
	private TicketDetails ticket;

	public Booking() {
		super();
	
	}

	public Booking(int bookingId, String bookingType, String description, String bookingTitle, LocalDate bookingDate,
			Package pack, int userId, PaymentDetails payment, TicketDetails ticket) {
		super();
		this.bookingId = bookingId;
		this.bookingType = bookingType;
		this.description = description;
		this.bookingTitle = bookingTitle;
		this.bookingDate = bookingDate;
		this.pack = pack;
		this.userId = userId;
		this.payment = payment;
		this.ticket = ticket;
	}

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

	public Package getPack() {
		return pack;
	}

	public void setPack(Package pack) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
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
		Booking other = (Booking) obj;
		if (bookingId != other.bookingId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingType=" + bookingType + ", description=" + description
				+ ", bookingTitle=" + bookingTitle + ", bookingDate=" + bookingDate + ", pack=" + pack + ", userId="
				+ userId + ", payment=" + payment + ", ticket=" + ticket + "]";
	}

}
