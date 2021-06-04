package com.g5.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.g5.tms.dto.CustomerDto;
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

	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
	       
			if ((customer.getPassword() != null)) {
				String securedPasswordHash = BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt(12));
				customer.setPassword(securedPasswordHash);
			}
			customer.setUserType("3");
			custRepository.save(customer);

		
		return customer;
	}

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
	public CustomerDto displayCustomerDetails(Customer cust) {
	      CustomerDto custDto= new CustomerDto(cust.getUserId(), cust.getCustomerName(), cust.getAddress(), cust.getMobileNo(), cust.getEmail());
			return custDto;

		}
}
