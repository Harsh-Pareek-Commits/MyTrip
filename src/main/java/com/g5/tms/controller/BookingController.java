package com.g5.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.g5.service.IBookingService;

@RestController
public class BookingController {
	@Autowired
	IBookingService booking_service;
	
}
