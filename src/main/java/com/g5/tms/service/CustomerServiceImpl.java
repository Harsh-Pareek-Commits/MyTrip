package com.g5.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.g5.tms.entities.Customer;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.repository.IBookingRepository;
import com.g5.tms.repository.ICustomerRepository;
import com.g5.tms.repository.IPackageRepository;

 
@Service
public class CustomerServiceImpl implements ICustomerService {
	Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	ICustomerRepository custRepository;
	@Autowired
	IBookingRepository bookingRepository;
	@Autowired
	IPackageRepository packageRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	/*
	 *Author= Harsh Pareek
	 *Date= 24-May-2021
	 *Method name:addCustomer 
	 *Parameters: Customer object
	 *Return Type: Customer object*/
	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
	       
			if ((customer.getPassword() != null)) {
				String securedPasswordHash =passwordEncoder.encode(customer.getPassword());
				customer.setPassword(securedPasswordHash);
			}
			customer.setUserType("3");
			custRepository.save(customer);

		
		return customer;
	}
	/*
	 *Author= Harsh Pareek
	 *Date= 24-May-2021
	 *Method name: updateCustomer 
	 *Parameters: Customer object
	 *Return Type: Customer object*/
	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {

		
		try {

			Optional<Customer> opt =custRepository.findById(customer.getUserId());
			if (opt.isPresent()) {
				custRepository.save(customer);
				return opt.get();
			} else {
				throw new CustomerNotFoundException("Customer id not found for update.");
			}

		} catch (Exception e) {

			throw new CustomerNotFoundException("Customer id not found for update.");
		}
		
	}

	@Override
	@Transactional
	/*
	 *Author= Harsh Pareek
	 *Date= 24-May-2021
	 *Method name: deleteCustomer 
	 *Parameters: Customer object
	 *Return Type: Customer object
	 *
	 **/
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
				try {
					Optional<Customer> opt =  custRepository.findById(customer.getUserId());
			if (opt.isPresent()) {
				custRepository.delete(customer);
				return opt.get();
			} else {
				throw new CustomerNotFoundException("Customer id not found for delete.");
			}
		} catch (Exception e) {

			throw new CustomerNotFoundException("Customer id not found for delete.");
		}
		
	}
	/*
	 *Author= Harsh Pareek
	 *Date= 24-May-2021
	 *Method name: viewCustomer 
	 *Parameters: Customer int id
	 *Return Type: Customer object
	 *
	 **/
	@Override
	public Customer viewCustomer(int custid) throws CustomerNotFoundException {
		Customer cust = null;
		try {
			Optional<Customer> opt = custRepository.findById(custid);
			if (opt.isPresent()) {
				cust = opt.get();
			} else {
				throw new CustomerNotFoundException("Customer id not found in view cutomer by id");
			}
		} catch (Exception e) {

			throw new CustomerNotFoundException("Customer id not found in view cutomer by id");
		}
		return cust;
	}
	/*
	 *Author= Harsh Pareek
	 *Date= 24-May-2021
	 *Method name: viewAllCustomers 
	 *Parameters: Package int id
	 *Return Type: list of Customer object
	 *
	 **/
	@Override
	public List<Customer> viewAllCustomers(int packageId) throws PackageNotFoundException {
		List<Customer> custList = null;

		try {

			custList = custRepository.findByPackageId(packageId);
			if (custList.isEmpty()) {
				throw new PackageNotFoundException("Package not found");
			}

		} catch (Exception e) {

			throw new PackageNotFoundException("Package not found");
		}
		return custList;
	}
	/*
	 *Author= Harsh Pareek
	 *Date= 24-May-2021
	 *Method name: viewCustomerList 
	 *Parameters: Route int id
	 *Return Type:list of Customer object
	 *
	 **/
	@Override
	public List<Customer> viewCustomerList(int routeId) throws RouteNotFoundException {

		List<Customer> custList = null;
		try {
			custList = custRepository.findByRouteId(routeId);
			if (custList.isEmpty()) {
				throw new RouteNotFoundException("Route not found");
			}

		} catch (Exception e) {

			throw new RouteNotFoundException("Route not found");
		}
		return custList;
	}
	
	
	 
}
