package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.dto.BookingDto;

import com.g5.tms.entities.Booking;

import com.g5.tms.entityDto.BookingEntityDto;
import com.g5.tms.exceptions.BookingNotFoundException;
import com.g5.tms.service.IBookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.internal.org.jline.utils.Log;

@RestController
@RequestMapping("/booking")
@Api(value = "Trip Management Application")
public class BookingController {
	@Autowired
	IBookingService bookingService;
	@Autowired
	private ModelMapper modelMapper;
	
	Logger log = LoggerFactory.getLogger(BookingController.class);
	
	@ApiOperation(value = "Booking Post mapping for booking", response = Booking.class)
	@PostMapping("/add")
	public ResponseEntity<BookingDto> makeBooking(@RequestBody @Valid BookingEntityDto requestbooking) {
		
		log.info("Inside make booking");
		Booking actualbooking = modelMapper.map(requestbooking, Booking.class);
		BookingDto responsebooking = modelMapper.map(this.bookingService.makeBooking(actualbooking), BookingDto.class);
		return new ResponseEntity<>(responsebooking, HttpStatus.OK);
		
	}

	@ApiOperation(value = "Booking Delete mapping to cancel booking", response = Booking.class)
	@DeleteMapping("/delete/{bookingId}")
	public ResponseEntity<BookingDto> cancelBooking(@PathVariable int bookingId) throws BookingNotFoundException {
		
		log.info("Inside delete or cancel booking");
		BookingDto responsebooking = modelMapper.map(this.bookingService.cancelBooking(bookingId), BookingDto.class);
		if (responsebooking != null) {
			return new ResponseEntity<>(responsebooking, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsebooking, HttpStatus.BAD_REQUEST);
		}
		 
	}

	
	@ApiOperation(value = "Booking Get mapping to fetch booking by booking id", response = Booking.class)
	@GetMapping("/view/{bookingId}")
	public ResponseEntity<BookingDto> viewBooking(@PathVariable int bookingId) throws BookingNotFoundException {
    
     log.info("Inside Get booking information by booking id");
     BookingDto responsebooking = modelMapper.map(this.bookingService.viewBooking(bookingId), BookingDto.class);
		if (responsebooking != null) {
			return new ResponseEntity<>(responsebooking, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsebooking, HttpStatus.BAD_REQUEST);
		}
	}

	
	@ApiOperation(value = "Booking Get mapping to fetch all bookings")
	@GetMapping("/view")
	public ResponseEntity<List<BookingDto>> viewAllBookings() {
       
		log.info("Inside Get all bookings information");
        List<Booking> bookingList = this.bookingService.viewAllBookings();
		List<BookingDto> bookingDtoList = new ArrayList<>();
		for (Booking b : bookingList) {
			BookingDto bookingdto = modelMapper.map(b, BookingDto.class);
			bookingDtoList.add(bookingdto);
		}
		if (!(bookingDtoList.isEmpty())) {
			return new ResponseEntity<>(bookingDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(bookingDtoList, HttpStatus.BAD_REQUEST);
		}
	}
}
