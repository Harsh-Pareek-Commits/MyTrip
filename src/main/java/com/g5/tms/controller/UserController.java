package com.g5.tms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.entities.User;
import com.g5.tms.exceptions.InvalidCredentialException;
import com.g5.tms.security.JwtResponse;
import com.g5.tms.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api("Travel Management Application")
public class UserController {
	@Autowired
	IUserService userService;
	/*
	 *Author= Iflak Yousuf Mir
	 *Date= 24-May-2021
	 *Method name: addUser
	 *Parameters: user object
	 *Return Type: user object
	 *
	 **/
	@ApiOperation(value = "User Post mapping to add user", response = User.class)
	@PostMapping("/add")
	public User adduser(@RequestBody @Valid User user)
	{
		this.userService.addNewUser(user);
		return user;
	}
	/*
	 *Author= Iflak Yousuf Mir
	 *Date= 24-May-2021
	 *Method name: signuser
	 *Parameters: user object
	 *Return Type: user object
	 *
	 **/
	@ApiOperation(value = "User Post mapping for user signing in", response = User.class)
	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> signuser(@RequestBody @Valid User user) throws InvalidCredentialException
	{
		
		return new ResponseEntity<>(new JwtResponse(this.userService.signIn(user)), HttpStatus.OK);

	}
	/*
	 *Author= Iflak Yousuf Mir
	 *Date= 
	 *Method name: signout
	 *Parameters: user object
	 *Return Type: user object
	 *
	 **/
	@ApiOperation(value = "User Post mapping for user signing out", response = User.class)
	@PostMapping("/signout")
	public ResponseEntity<User> signoutuser(@RequestBody @Valid User user) 
	{
	this.userService.signOut(user);
	return new ResponseEntity<>(user, HttpStatus.RESET_CONTENT);

	}
	
}
