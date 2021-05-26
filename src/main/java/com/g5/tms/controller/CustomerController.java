package com.g5.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.entities.Customer;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService cust_service;

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer cust) {
		this.cust_service.addCustomer(cust);
		return cust;
	}

	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer cust) throws CustomerNotFoundException {
		this.cust_service.updateCustomer(cust);
		return cust;
	}
     @DeleteMapping("/delete")  
	public Customer deleteCustomer(@RequestBody Customer cust) throws CustomerNotFoundException {
    	 this.cust_service.deleteCustomer(cust);
		return cust;
	}
    @GetMapping("/view/{custid}")
	public Customer viewCustomer(@PathVariable int custid) throws CustomerNotFoundException {
    	
    	return cust_service.viewCustomer(custid);
	}
    @GetMapping("/view/package/{id}")
	public List<Customer> viewAllCustomers(@PathVariable int packageId) throws PackageNotFoundException {
    	List<Customer> cust_list;
    	cust_list=this.cust_service.viewAllCustomers(packageId);
		return cust_list;
	}
    @GetMapping("/view/route/{id}")
	public List<Customer> viewCustomerList(@PathVariable int routeId) throws RouteNotFoundException {
    
    	return this.cust_service.viewCustomerList(routeId);
		
	}

}
