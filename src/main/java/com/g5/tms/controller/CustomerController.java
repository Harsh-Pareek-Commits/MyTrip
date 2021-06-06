package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.dto.CustomerDto;
import com.g5.tms.entities.Customer;
import com.g5.tms.entityDto.CustomerEntityDto;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.service.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
@Api(value = "Travel Management Application")
public class CustomerController {
	@Autowired
	ICustomerService custService;
	@Autowired
	private ModelMapper modelMapper;

	Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@ApiOperation(value = "Customer Post mapping", response = CustomerController.class)
	@PostMapping(value = "/add")
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody @Valid CustomerEntityDto requestCust) {

		log.info("Inside add customer");
		Customer actualCust = modelMapper.map(requestCust, Customer.class);
		CustomerDto responseCust = modelMapper.map(this.custService.addCustomer(actualCust), CustomerDto.class);
		return new ResponseEntity<>(responseCust, HttpStatus.OK);
	}

	
	@ApiOperation(value = "Customer Put mapping to update customer", response = Customer.class)
	@PutMapping("/update")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody @Valid CustomerEntityDto requestCust)
			throws CustomerNotFoundException {

		log.info("Inside update customer");
		Customer actualCust = modelMapper.map(requestCust, Customer.class);
		CustomerDto responseCust = modelMapper.map(this.custService.updateCustomer(actualCust), CustomerDto.class);

		if (responseCust != null) {
			return new ResponseEntity<>(responseCust, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseCust, HttpStatus.BAD_REQUEST);
		}
	}

	
	@ApiOperation(value = "Customer Delete mapping to delete customer", response = Customer.class)
	@DeleteMapping("/delete")
	public ResponseEntity<CustomerDto> deleteCustomer(@RequestBody @Valid CustomerEntityDto requestCust)
			throws CustomerNotFoundException {
		
		log.info("Inside delete customer");
		Customer actualCust = modelMapper.map(requestCust, Customer.class);
		CustomerDto responseCust = modelMapper.map(this.custService.deleteCustomer(actualCust), CustomerDto.class);

		if (responseCust != null) {
			return new ResponseEntity<>(responseCust, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseCust, HttpStatus.BAD_REQUEST);
		}
	}

	
	@ApiOperation(value = "Customer Get mapping to fetch customer using customer Id", response = Customer.class)
	@GetMapping("/view/{custid}")
	public ResponseEntity<CustomerDto> viewCustomer(@PathVariable int custid) throws CustomerNotFoundException {

		log.info("Inside finding customer by customer id");
		CustomerDto responseCust = modelMapper.map(this.custService.viewCustomer(custid), CustomerDto.class);
		if (responseCust != null) {
			return new ResponseEntity<>(responseCust, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseCust, HttpStatus.BAD_REQUEST);
		}
	}

	
	@ApiOperation(value = "Customer Get mapping to fetch all the customers", response = List.class)
	@GetMapping("/view/package/{packageId}")
	public ResponseEntity<List<CustomerDto>> viewAllCustomers(@PathVariable int packageId)
			throws PackageNotFoundException {

		log.info("Inside find all customers");
		List<Customer> custList = this.custService.viewAllCustomers(packageId);
		List<CustomerDto> custDtoList = new ArrayList<>();
		for (Customer c : custList) {
			CustomerDto custdto = modelMapper.map(c, CustomerDto.class);
			custDtoList.add(custdto);
		}
		if (!(custDtoList.isEmpty())) {
			return new ResponseEntity<>(custDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(custDtoList, HttpStatus.BAD_REQUEST);
		}
	}
	
	

	@ApiOperation(value = "Customer Get mapping to fetch the list of customers using route id", response = List.class)
	@GetMapping("/view/route/{routeId}")
	public ResponseEntity<List<@NotBlank CustomerDto>> viewCustomerList(@PathVariable int routeId)
			throws RouteNotFoundException {

		log.info("Inside finding list of customers using route id");
		List<Customer> custList = this.custService.viewCustomerList(routeId);
		List<CustomerDto> custDtoList = new ArrayList<>();
		for (Customer c : custList) {
			CustomerDto custdto = modelMapper.map(c, CustomerDto.class);
			custDtoList.add(custdto);
		}
		if (!(custDtoList.isEmpty())) {
			return new ResponseEntity<>(custDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(custDtoList, HttpStatus.BAD_REQUEST);
		}
	}

}
