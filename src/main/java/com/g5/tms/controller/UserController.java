package com.g5.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.g5.service.IUserService;

@RestController
public class UserController {
	@Autowired
	IUserService user_service;
}
