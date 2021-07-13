package com.g5.tms.controller;

import javax.validation.Valid;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.dto.CustomerDto;
import com.g5.tms.dto.PackageDto;
import com.g5.tms.entities.Package;
import com.g5.tms.entities.Razorpay_order;
import com.g5.tms.entitydto.PackageEntityDto;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.service.CheckoutService;
import com.razorpay.RazorpayException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/checkout")
@Api("Travel Management Application")
public class Checkout {
	@Autowired
	CheckoutService checkoutService;
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	@ApiOperation(value = "Package Post mapping to add package", response = Package.class)
	@GetMapping("/{type}/{id}")
	public ResponseEntity<Razorpay_order>  checkout(@PathVariable String type,@PathVariable int id) throws RazorpayException {
	  return new ResponseEntity<>( this.checkoutService.checkout(type, id), HttpStatus.OK);
	 
	}
}
