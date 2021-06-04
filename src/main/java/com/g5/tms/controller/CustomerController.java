package com.g5.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;
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
import com.g5.tms.dto.CustomerEntityDto;
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
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping(value = "/add")
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody @Valid CustomerEntityDto requestCust) {

		Customer actualCust = modelMapper.map(requestCust, Customer.class);
		CustomerDto responseCust = modelMapper.map(this.custService.addCustomer(actualCust), CustomerDto.class);
		return new ResponseEntity<>(responseCust, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody @Valid CustomerEntityDto requestCust)
			throws CustomerNotFoundException {

		Customer actualCust = modelMapper.map(requestCust, Customer.class);
		CustomerDto responseCust = modelMapper.map(this.custService.updateCustomer(actualCust), CustomerDto.class);

		if (responseCust != null) {
			return new ResponseEntity<>(responseCust, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseCust, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<CustomerDto> deleteCustomer(@RequestBody @Valid CustomerEntityDto requestCust)
			throws CustomerNotFoundException {
		Customer actualCust = modelMapper.map(requestCust, Customer.class);
		CustomerDto responseCust = modelMapper.map(this.custService.deleteCustomer(actualCust), CustomerDto.class);

		if (responseCust != null) {
			return new ResponseEntity<>(responseCust, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseCust, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view/{custid}")
	public ResponseEntity<CustomerDto> viewCustomer(@PathVariable int custid) throws CustomerNotFoundException {

		CustomerDto responseCust = modelMapper.map(this.custService.viewCustomer(custid), CustomerDto.class);
		if (responseCust != null) {
			return new ResponseEntity<>(responseCust, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseCust, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view/package/{packageId}")
	public ResponseEntity<List<CustomerDto>> viewAllCustomers(@PathVariable int packageId)
			throws PackageNotFoundException {

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

	@GetMapping("/view/route/{routeId}")
	public ResponseEntity<List<@NotBlank CustomerDto>> viewCustomerList(@PathVariable int routeId)
			throws RouteNotFoundException {

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
