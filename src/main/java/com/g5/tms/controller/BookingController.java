package com.g5.tms.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.entities.Booking;
import com.g5.tms.exceptions.BookingNotFoundException;
import com.g5.tms.service.IBookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	IBookingService bookingService;

	@PostMapping("/add")
	public Booking makeBooking(@RequestBody @Valid Booking booking) {
		this.bookingService.makeBooking(booking);
		return booking;
	}

	@DeleteMapping("/delete/{bookingId}")
	public Booking cancelBooking(@PathVariable int bookingId) throws BookingNotFoundException {
		return this.bookingService.cancelBooking(bookingId);
		 
	}

	@GetMapping("/view/{bookingId}")
	public Booking viewBooking(@PathVariable int bookingId) throws BookingNotFoundException {
     return this.bookingService.viewBooking(bookingId);
	}

	@GetMapping("/view")
	public List<@NotBlank Booking> viewAllBookings() {
        return this.bookingService.viewAllBookings();
	}
}
