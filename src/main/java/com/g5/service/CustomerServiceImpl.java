package com.g5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.entities.Booking;
import com.g5.entities.Customer;
import com.g5.entities.Package;
import com.g5.exceptions.CustomerNotFoundException;
import com.g5.exceptions.PackageNotFoundException;
import com.g5.exceptions.RouteNotFoundException;
import com.g5.repository.IBookingRepository;
import com.g5.repository.ICustomerRepository;
import com.g5.repository.IPackageRepository;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepository cust_repo;
	@Autowired
	IBookingRepository booking_repo;
	@Autowired
	IPackageRepository package_repo;

	@Override
	public Customer addCustomer(Customer customer) {
		try {
			cust_repo.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<Customer>opt=null;
		try {
			opt= cust_repo.findById(customer.getUserId());
			cust_repo.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomerNotFoundException("Customer id not found for update.");
		}
		return opt.get();
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<Customer>opt=null;
		try {
			opt=cust_repo.findById(customer.getUserId());
			cust_repo.delete(customer);
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
			throw new CustomerNotFoundException("Customer id not found");
		}
		return cust;
	}

	@Override
	public List<Customer> viewAllCustomers(int packageId) throws PackageNotFoundException {
		List<Customer> cust_list = null;
		
		try {

       cust_list=cust_repo.findByPackageId(packageId);		
		} catch (Exception e) {
			e.printStackTrace();
			throw new PackageNotFoundException("Package not found");
		}
		return cust_list;
	}

	@Override
	public List<Customer> viewCustomerList(int routeId) throws RouteNotFoundException {
		List<Customer> cust_list = null;
		List<Package> package_list = null;
		try {
         package_list=package_repo.findByRouteId(routeId);
         for(Package pack:package_list) {
        	 cust_list.addAll(cust_repo.findByPackageId(pack.getPackageId()));
         }
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new RouteNotFoundException("Route not found");
		}
		return cust_list;
	}

}
