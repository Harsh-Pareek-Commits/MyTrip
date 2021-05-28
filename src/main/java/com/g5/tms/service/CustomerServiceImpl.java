package com.g5.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.tms.entities.Booking;
import com.g5.tms.entities.Customer;
import com.g5.tms.entities.Package;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.repository.IBookingRepository;
import com.g5.tms.repository.ICustomerRepository;
import com.g5.tms.repository.IPackageRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepository cust_repo;
	@Autowired
	IBookingRepository booking_repo;
	@Autowired
	IPackageRepository package_repo;

	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		try {
			cust_repo.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<Customer> opt = null;
		try {
			
			opt = cust_repo.findById(customer.getUserId());
			if(opt.isPresent()) {
				cust_repo.save(customer);
			}
			else {
				throw new CustomerNotFoundException("Customer id not found for update.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomerNotFoundException("Customer id not found for update.");
		}
		return opt.get();
	}

	@Override
	@Transactional
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<Customer> opt = null;
		try {
			opt = cust_repo.findById(customer.getUserId());
			if(opt.isPresent()) {
			cust_repo.delete(customer);
			}
			else {
				throw new CustomerNotFoundException("Customer id not found for delete.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomerNotFoundException("Customer id not found for delete.");
		}
		return opt.get();
	}

	@Override
	public Customer viewCustomer(int custid) throws CustomerNotFoundException {
		Customer cust = null;
		try {
			cust = cust_repo.findById(custid).get();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomerNotFoundException("Customer id not found in view cutomer by id");
		}
		return cust;
	}

	@Override
	public List<Customer> viewAllCustomers(int packageId) throws PackageNotFoundException {
		List<Customer> cust_list = null;

		try {

			cust_list = cust_repo.findByPackageId(packageId);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PackageNotFoundException("Package not found");
		}
		return cust_list;
	}

	@Override
	public List<Customer> viewCustomerList(int routeId) throws RouteNotFoundException {
		
		
		List<Customer> cust_list = null;
		try {
			cust_list = cust_repo.findByRouteId(routeId);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RouteNotFoundException("Route not found");
		}
		return cust_list;
	}

}
