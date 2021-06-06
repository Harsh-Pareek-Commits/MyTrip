package com.g5.tms.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.entities.User;
import com.g5.tms.exceptions.InvalidCredentialException;
import com.g5.tms.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api("Travel Management Application")
public class UserController {
	@Autowired
	IUserService userService;
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@ApiOperation(value = "User Post mapping to add user", response = User.class)
	@PostMapping("/add")
	public User adduser(@RequestBody @Valid User user)
	{
		log.info("Inside add user");
		this.userService.addNewUser(user);
		return user;
	}
	
	@ApiOperation(value = "User Post mapping for user signing in", response = User.class)
	@PostMapping("/signin")
	public User signuser(@RequestBody @Valid User user) throws InvalidCredentialException
	{
		log.info("Inside user sign in");
		this.userService.signIn(user);
		return user;
	}
	
	@ApiOperation(value = "User Post mapping for user signing out", response = User.class)
	@PostMapping("/signout")
	public User signoutuser(@RequestBody @Valid User user) 
	{
		log.info("Inside user sign out");
		this.userService.signOut(user);
		return user;
	}
	
}
