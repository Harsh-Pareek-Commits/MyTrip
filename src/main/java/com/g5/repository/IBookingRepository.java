package com.g5.repository;

import java.util.List;

import com.g5.entities.Booking;
import com.g5.exceptions.BookingNotFoundException;



public interface IBookingRepository {
	
	
	public  Booking  makeBooking(Booking booking);
	public  Booking  cancelBooking(int bookingId) throws BookingNotFoundException;
	public  Booking  viewBooking(int bookingId)throws BookingNotFoundException;
	public List<Booking> viewAllBookings();
	
	
	
	
	

}
