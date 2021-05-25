package com.g5.repository;


import java.util.List;

import com.g5.entities.Customer;
import com.g5.exceptions.CustomerNotFoundException;
import com.g5.exceptions.PackageNotFoundException;
import com.g5.exceptions.RouteNotFoundException;



public interface ICustomerRepository {

	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer viewCustomer(int custid) throws CustomerNotFoundException;
	public List<Customer> viewAllCustomers(int packageId)throws PackageNotFoundException;
	public List<Customer> viewCustomerList(int routeId)throws RouteNotFoundException;

	
	
	
}
