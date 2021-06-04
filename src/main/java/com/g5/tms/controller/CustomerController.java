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
	CustomerServiceImpl custService;

	@PostMapping(value = "/add")
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody @Valid Customer cust) {
		Customer customer = this.custService.addCustomer(cust);
		CustomerDto custdto = this.custService.displayCustomerDetails(customer);
		return new ResponseEntity<>(custdto, HttpStatus.OK);	}
	

	@PutMapping("/update")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody @Valid Customer cust)
			throws CustomerNotFoundException {
		Customer customer = this.custService.updateCustomer(cust);
		CustomerDto custdto = this.custService.displayCustomerDetails(customer);
		if (custdto != null) {
			return new ResponseEntity<>(custdto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(custdto, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<CustomerDto> deleteCustomer(@RequestBody @Valid Customer cust)
			throws CustomerNotFoundException {
		Customer customer = this.custService.deleteCustomer(cust);
		CustomerDto custdto = this.custService.displayCustomerDetails(customer);
		if (custdto != null) {
			return new ResponseEntity<>(custdto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(custdto, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view/{custid}")
	public ResponseEntity<CustomerDto> viewCustomer(@PathVariable int custid) throws CustomerNotFoundException {

		Customer customer = custService.viewCustomer(custid);
		CustomerDto custdto = this.custService.displayCustomerDetails(customer);
		if (custdto != null) {
			return new ResponseEntity<>(custdto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(custdto, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view/package/{packageId}")
	public ResponseEntity<List<CustomerDto>> viewAllCustomers(@PathVariable int packageId)
			throws PackageNotFoundException {
		List<Customer> custList = this.custService.viewAllCustomers(packageId);
		List<CustomerDto> custDtoList = new ArrayList<>();
		for (Customer c : custList) {
			CustomerDto custdto = this.custService.displayCustomerDetails(c);
			custDtoList.add(custdto);
		}
		if (!(custDtoList.isEmpty())) {
			return new ResponseEntity<>(custDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(custDtoList, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view/route/{routeId}")
	public ResponseEntity<List<@NotBlank CustomerDto>> viewCustomerList(@PathVariable int routeId)
			throws RouteNotFoundException {

		List<Customer> custList = this.custService.viewCustomerList(routeId);
		List<CustomerDto> custDtoList = new ArrayList<>();
		for (Customer c : custList) {
			CustomerDto custdto = this.custService.displayCustomerDetails(c);
			custDtoList.add(custdto);
		}
		if (!(custDtoList.isEmpty())) {
			return new ResponseEntity<>(custDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(custDtoList, HttpStatus.BAD_REQUEST);
		}
	}

}
