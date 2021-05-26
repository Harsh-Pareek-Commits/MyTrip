package com.g5.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.service.ITravelsService;

@RestController
public class TravelController {
	@Autowired
ITravelsService travel_service;

}
