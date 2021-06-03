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
	IBookingRepository booking_repo;

	@Override
	@Transactional
	public Booking makeBooking(Booking booking) {
		try {
			booking_repo.save(booking);
		} catch (Exception e) {
			log.error("Exception:",e);
		}
		return booking;
	}

	@Override
	public Booking cancelBooking(int bookingId) throws BookingNotFoundException {

		try {
			Optional<Booking> opt;
			opt = booking_repo.findById(bookingId);
			if (opt.isPresent()) {
				booking_repo.deleteById(bookingId);
				return opt.get();
			} else {
				throw new BookingNotFoundException("No booking found for cancel!");
			}
		} catch (Exception e) {
			log.error("Exception:",e);
			throw new BookingNotFoundException("No booking found for cancel!");
		}

	}

	@Override
	public Booking viewBooking(int bookingId) throws BookingNotFoundException {
		Booking booking = null;
		try {
			Optional<Booking> opt = booking_repo.findById(bookingId);
			if (opt.isPresent()) {
				booking = opt.get();
			} else {
				throw new BookingNotFoundException("No booking found for view booking!");
			}
		} catch (Exception e) {
			log.error("Exception:",e);
			throw new BookingNotFoundException("No booking found for view booking!");
		}
		return booking;
	}

	@Override
	public List<Booking> viewAllBookings() {
		List<Booking> booking_list = null;
		try {
			booking_list = booking_repo.findAll();

		} catch (Exception e) {
			log.error("Exception:",e);
		}
		return booking_list;
	}

}
