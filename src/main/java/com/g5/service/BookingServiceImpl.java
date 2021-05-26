package com.g5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.entities.Booking;
import com.g5.exceptions.BookingNotFoundException;
import com.g5.repository.IBookingRepository;
@Service
public class BookingServiceImpl implements IBookingService {
	@Autowired
	IBookingRepository booking_repo;

	@Override
	@Transactional
	public Booking makeBooking(Booking booking) {
		try {
			booking_repo.save(booking);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booking;
	}

	@Override
	public Booking cancelBooking(int bookingId) throws BookingNotFoundException {
		Optional<Booking> opt =null;
		try {
			opt=booking_repo.findById(bookingId);
			
			booking_repo.deleteById(bookingId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BookingNotFoundException("No booking found for cancel!");
		}
		return opt.get();
	}

	@Override
	public Booking viewBooking(int bookingId) throws BookingNotFoundException {
		Booking booking = null;
		try {
			booking = booking_repo.findById(bookingId).get();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BookingNotFoundException("No booking found for view booking!");
		}
		return booking;
	}

	@Override
	public List<Booking> viewAllBookings() {
		List<Booking> booking_list=null;
		try {
			booking_list=booking_repo.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return booking_list;
	}

}
