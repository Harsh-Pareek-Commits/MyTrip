package com.g5.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.tms.entities.Booking;
import com.g5.tms.exceptions.BookingNotFoundException;
import com.g5.tms.repository.IBookingRepository;

@Service
public class BookingServiceImpl implements IBookingService {

	Logger log = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	IBookingRepository bookingRepository;

	@Override
	@Transactional
	/*
	 *Author= Harsh Pareek
	 *Date= 24-May-2021
	 *Method name: makeBooking 
	 *Parameters: Booking object
	 *Return Type: Booking object
	 *
	 **/
	public Booking makeBooking(Booking booking) {
		try {
			double netAmount=booking.getPack().getPackageCost();
		
			netAmount+=(netAmount*0.05);
			booking.getPayment().setNetAmount(netAmount);
			bookingRepository.save(booking);
		} catch (Exception e) {
			log.error("Booking exp:", e);

		}
		return booking;
	}
	/*
	 *Author= Harsh Pareek
	 *Date= 24-May-2021
	 *Method name: cancelBooking 
	 *Parameters: Booking int id
	 *Return Type: Booking object
	 *
	 **/
	@Override
	public Booking cancelBooking(int bookingId) throws BookingNotFoundException {

		try {

			Optional<Booking> opt = bookingRepository.findById(bookingId);
			if (opt.isPresent()) {
				bookingRepository.deleteById(bookingId);
				return opt.get();
			} else {
				throw new BookingNotFoundException("No booking found for cancel!");
			}
		} catch (Exception e) {

			throw new BookingNotFoundException("No booking found for cancel!");
		}

	}
	/*
	 *Author= Harsh Pareek
	 *Date= 24-May-2021
	 *Method name: viewBooking 
	 *Parameters: Booking int id
	 *Return Type: Booking object
	 *
	 **/
	@Override
	public Booking viewBooking(int bookingId) throws BookingNotFoundException {

		try {
			Optional<Booking> opt = bookingRepository.findById(bookingId);
			if (opt.isPresent()) {
				return  opt.get();
				
			} else {
				throw new BookingNotFoundException("No booking found for view booking!");
			}
		} catch (Exception e) {

			throw new BookingNotFoundException("No booking found for view booking!");
		}
		
	}
	/*
	 *Author= Harsh Pareek
	 *Date= 24-May-2021
	 *Method name: viewAllBookings 
	 *Parameters:no parameter
	 *Return Type:list of  Booking object
	 *
	 **/
	@Override
	public List<Booking> viewAllBookings() {
		List<Booking> bookingList = null;
		try {
			bookingList = bookingRepository.findAll();

		} catch (Exception e) {
			log.error("Booking list exception:", e);
		}
		return bookingList;
	}

}
