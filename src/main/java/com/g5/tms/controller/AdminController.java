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
import com.g5.tms.entitydto.AdminEntityDto;
import com.g5.tms.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
@Api(value = "Trip Management Application")
public class AdminController {
	@Autowired
	IUserService adminService;
	@Autowired
	private ModelMapper modelMapper;

	private int userId;
	
	@ApiOperation(value = "Admin Post mapping to add user", response = Admin.class)
	@PostMapping("/add")
	public ResponseEntity<AdminDto> addAdmin(@RequestBody @Valid AdminEntityDto admin)
	{

		Admin actualAdmin = modelMapper.map(admin, Admin.class);
		AdminDto responseAdmin = modelMapper.map(this.adminService.addNewUser(actualAdmin), AdminDto.class);
		return new ResponseEntity<>(responseAdmin, HttpStatus.OK);
	}
}
