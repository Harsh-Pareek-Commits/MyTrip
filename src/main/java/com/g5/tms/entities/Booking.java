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

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	@Column
	@NotEmpty(message = "Booking Type cannot be left empty or null ")
	@Size(min = 3,message = "Invaid Booking Type")
	private String bookingType;
	@Column
	@Size(min = 3,max =50 ,message = "description should be min of 3 and max of 50 characters")
	private String description;
	@Column
	@NotEmpty(message = "BookingTitle cannot be left blank or null")
	@Size(min = 5,max = 20, message = "Invalid Booking Title")
	private String bookingTitle;
	@FutureOrPresent(message="Date cannot be in Past")
	private LocalDate bookingDate;
	@OneToOne
	@JoinColumn(name = "Package_info", referencedColumnName = "packageId")
	@Valid
	private Package pack;
	@Column
	@Positive
	private int userId;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Payment_info", referencedColumnName = "paymentId")
	@Valid
	private PaymentDetails payment;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Ticket_info", referencedColumnName = "ticketId")
	@Valid
	private TicketDetails ticket;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
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
