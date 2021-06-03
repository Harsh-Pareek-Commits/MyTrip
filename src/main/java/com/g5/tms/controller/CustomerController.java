package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.service.CustomerServiceImpl;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerServiceImpl cust_service;

	@PostMapping("/add")
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody @Valid Customer cust) {
		Customer customer = this.cust_service.addCustomer(cust);
		CustomerDto custdto = this.cust_service.displayCustomerDetails(customer);
		return new ResponseEntity<CustomerDto>(custdto, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody @Valid Customer cust)
			throws CustomerNotFoundException {
		Customer customer = this.cust_service.updateCustomer(cust);
		CustomerDto custdto = this.cust_service.displayCustomerDetails(customer);
		if (custdto != null) {
			return new ResponseEntity<CustomerDto>(custdto, HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomerDto>(custdto, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<CustomerDto> deleteCustomer(@RequestBody @Valid Customer cust)
			throws CustomerNotFoundException {
		Customer customer = this.cust_service.deleteCustomer(cust);
		CustomerDto custdto = this.cust_service.displayCustomerDetails(customer);
		if (custdto != null) {
			return new ResponseEntity<CustomerDto>(custdto, HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomerDto>(custdto, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view/{custid}")
	public ResponseEntity<CustomerDto> viewCustomer(@PathVariable int custid) throws CustomerNotFoundException {

		Customer customer = cust_service.viewCustomer(custid);
		CustomerDto custdto = this.cust_service.displayCustomerDetails(customer);
		if (custdto != null) {
			return new ResponseEntity<CustomerDto>(custdto, HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomerDto>(custdto, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view/package/{packageId}")
	public ResponseEntity<List<CustomerDto>> viewAllCustomers(@PathVariable int packageId)
			throws PackageNotFoundException {
		List<Customer> cust_list = this.cust_service.viewAllCustomers(packageId);
		List<CustomerDto> custDto_list = new ArrayList<>();
		for (Customer c : cust_list) {
			CustomerDto custdto = this.cust_service.displayCustomerDetails(c);
			custDto_list.add(custdto);
		}
		if (!(custDto_list.isEmpty())) {
			return new ResponseEntity<List<CustomerDto>>(custDto_list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<CustomerDto>>(custDto_list, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view/route/{routeId}")
	public ResponseEntity<List<@NotBlank CustomerDto>> viewCustomerList(@PathVariable int routeId) throws RouteNotFoundException {

		List<Customer> cust_list =  this.cust_service.viewCustomerList(routeId);
		List<CustomerDto> custDto_list = new ArrayList<>();
		for (Customer c : cust_list) {
			CustomerDto custdto = this.cust_service.displayCustomerDetails(c);
			custDto_list.add(custdto);
		}
		if (!(custDto_list.isEmpty())) {
			return new ResponseEntity<List<CustomerDto>>(custDto_list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<CustomerDto>>(custDto_list, HttpStatus.BAD_REQUEST);
		}
	}

}
