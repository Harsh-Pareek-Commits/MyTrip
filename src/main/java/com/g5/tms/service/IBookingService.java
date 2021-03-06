package com.g5.tms.service;

import java.util.List;

import com.g5.tms.entities.Booking;
import com.g5.tms.entities.TicketDetails;
import com.g5.tms.exceptions.BookingNotFoundException;

public interface IBookingService {
	
	
	public  Booking  makeBooking(Booking booking);
	public  Booking  ticketdetails(int ticketId) throws BookingNotFoundException;
	public  Booking  cancelBooking(int bookingId) throws BookingNotFoundException;
	public  Booking  viewBooking(int bookingId)throws BookingNotFoundException;
	public List<Booking> viewAllBookings();
	public List<Booking> viewAllCustomerBookings(int id);
	
	
	
	
	

}
