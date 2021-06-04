package com.g5.tms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import com.g5.tms.dto.AdminDto;

import com.g5.tms.entities.Admin;

import com.g5.tms.entityDto.AdminEntityDto;
import com.g5.tms.service.IUserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IUserService adminService;
	@Autowired
	private ModelMapper modelMapper;
	@PostMapping("/add")
	public ResponseEntity<AdminDto> adduser(@RequestBody @Valid AdminEntityDto admin)
	{
		
		Admin actualAdmin = modelMapper.map(admin, Admin.class);
		AdminDto responseAdmin = modelMapper.map(this.adminService.addNewUser(actualAdmin), AdminDto.class);
		return new ResponseEntity<>(responseAdmin, HttpStatus.OK);
	}
}
