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
	public Booking makeBooking(Booking booking) {
		try {
			bookingRepository.save(booking);
		} catch (Exception e) {
			log.error("Booking exp:", e);
		}
		return booking;
	}

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
