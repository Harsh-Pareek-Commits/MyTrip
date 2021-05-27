package com.g5.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.entities.Admin;
import com.g5.tms.entities.User;
import com.g5.tms.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminServiceImpl admin_service;
	@PostMapping("/add")
	public User adduser(@RequestBody Admin admin)
	{
		this.admin_service.addNewUser(admin);
		return admin;
	}
}
