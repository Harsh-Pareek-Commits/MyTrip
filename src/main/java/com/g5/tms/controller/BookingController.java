package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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
import com.g5.tms.entitydto.BookingEntityDto;
import com.g5.tms.exceptions.BookingNotFoundException;
import com.g5.tms.service.IBookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/booking")
@Api(value = "Trip Management Application")
public class BookingController {
	@Autowired
	IBookingService bookingService;
	@Autowired
	private ModelMapper modelMapper;

	@ApiOperation(value = "Booking Post mapping for booking", response = Booking.class)
	@PostMapping("/add")
	/*
	 *Author= Harsh Pareek
	 *Date= 26-May-2021
	 *Method name: makeBooking
	 *Parameters: Booking Entity DTO object
	 *Return Type: Booking object
	 *
	 **/
	public ResponseEntity<BookingDto> makeBooking(@RequestBody @Valid BookingEntityDto requestBooking) {

		Booking actualBooking = modelMapper.map(requestBooking, Booking.class);
		BookingDto responseBooking = modelMapper.map(this.bookingService.makeBooking(actualBooking), BookingDto.class);
		return new ResponseEntity<>(responseBooking, HttpStatus.OK);

	}
	/*
	 *Author= Harsh Pareek
	 *Date= 26-May-2021
	 *Method name: makeBooking
	 *Parameters: Booking Entity DTO object
	 *Return Type: Booking object
	 *
	 **/
	@ApiOperation(value = "Booking Delete mapping to cancel booking", response = Booking.class)
	@DeleteMapping("/delete/{bookingId}")
	public ResponseEntity<BookingDto> cancelBooking(@PathVariable int bookingId) throws BookingNotFoundException {

		BookingDto responseBooking = modelMapper.map(this.bookingService.cancelBooking(bookingId), BookingDto.class);
		if (responseBooking != null) {
			return new ResponseEntity<>(responseBooking, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseBooking, HttpStatus.BAD_REQUEST);
		}

	}
	/*
	 *Author= Harsh Pareek
	 *Date= 26-May-2021
	 *Method name: viewBooking
	 *Parameters: Booking int id
	 *Return Type: Booking object
	 *
	 **/
	@ApiOperation(value = "Booking Get mapping to fetch booking by booking id", response = Booking.class)
	@GetMapping("/view/{bookingId}")
	public ResponseEntity<BookingDto> viewBooking(@PathVariable int bookingId) throws BookingNotFoundException {

		BookingDto responseBooking = modelMapper.map(this.bookingService.viewBooking(bookingId), BookingDto.class);
		if (responseBooking != null) {
			return new ResponseEntity<>(responseBooking, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseBooking, HttpStatus.BAD_REQUEST);
		}
	}
	/*
	 *Author= Harsh Pareek
	 *Date= 26-May-2021
	 *Method name: viewAllBookings
	 *Parameters: no parameter
	 *Return Type: List of  Booking object
	 *
	 **/
	@ApiOperation(value = "Booking Get mapping to fetch all bookings")
	@GetMapping("/view")
	public ResponseEntity<List<BookingDto>> viewAllBookings() {

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
