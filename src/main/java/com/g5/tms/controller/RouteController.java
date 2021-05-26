package com.g5.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.g5.service.IReportService;

@RestController
public class RouteController {
	@Autowired
IReportService route_services;
}
