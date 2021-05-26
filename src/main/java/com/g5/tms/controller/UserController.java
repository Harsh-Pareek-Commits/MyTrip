package com.g5.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.entities.User;
import com.g5.tms.exceptions.InvalidCredentialException;
import com.g5.tms.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService user_service;
	@PostMapping("/add")
	public User adduser(@RequestBody User user)
	{
		this.user_service.addNewUser(user);
		return user;
	}
	@PostMapping("/signin")
	public User signuser(@RequestBody User user) throws InvalidCredentialException
	{
		this.user_service.signIn(user);
		return user;
	}
	@PostMapping("/signout")
	public User signoutuser(@RequestBody User user) 
	{
		this.user_service.signOut(user);
		return user;
	}
	
}
