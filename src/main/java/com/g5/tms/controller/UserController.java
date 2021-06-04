package com.g5.tms.controller;

import javax.validation.Valid;

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
	IUserService userService;
	@PostMapping("/add")
	public User adduser(@RequestBody @Valid User user)
	{
		this.userService.addNewUser(user);
		return user;
	}
	@PostMapping("/signin")
	public User signuser(@RequestBody @Valid User user) throws InvalidCredentialException
	{
		this.userService.signIn(user);
		return user;
	}
	@PostMapping("/signout")
	public User signoutuser(@RequestBody @Valid User user) 
	{
		this.userService.signOut(user);
		return user;
	}
	
}
