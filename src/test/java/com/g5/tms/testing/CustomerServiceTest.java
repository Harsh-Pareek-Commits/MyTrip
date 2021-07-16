package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.g5.tms.entities.Booking;
import com.g5.tms.entities.Customer;
import com.g5.tms.entities.Package;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.repository.ICustomerRepository;
import com.g5.tms.service.ICustomerService;

@SpringBootTest
@ActiveProfiles("test")

public class CustomerServiceTest {
	@Autowired
	private ICustomerService cust_Service;

	@Autowired
	private ICustomerRepository cust_repo;

	@Test
	public void testCustomerById() throws CustomerNotFoundException {
		Customer cust = new Customer("HARSH", "XYZYVC", "12312312312");
		cust.setUserType("3");
		cust.setUserId(1);
		Optional<Customer> opt = Optional.of(cust);
		Mockito.when(cust_repo.findById(1)).thenReturn(opt);
		Customer test_cust = cust_Service.viewCustomer(1);
		assertEquals(cust, test_cust);
	}

	@Test
	public void testCustomersByPackageId() throws PackageNotFoundException {
		Customer c1 = new Customer("HARSH", "XYZ", "12312312312");
		c1.setUserType("3");
		c1.setUserId(1);
		List<Customer> cust = Arrays.asList(c1);
		Mockito.when(cust_repo.findByPackageId(01)).thenReturn(cust);
		List<Customer> actual_custlist = cust_Service.viewAllCustomers(01);
		assertEquals(cust, actual_custlist);
	}

	@Test
	public void testCustomerByRouteId() throws RouteNotFoundException {
		Customer c1 = new Customer("HARSH", "XYZ", "12312312312");
		c1.setUserType("3");
		c1.setUserId(1);

		List<Customer> cust = Arrays.asList(c1);
		Mockito.when(cust_repo.findByRouteId(01)).thenReturn(cust);
		List<Customer> actual_custList = cust_Service.viewCustomerList(01);
		assertEquals(cust, actual_custList);

	}

	@Test
	public void testAddCustomer() throws Exception {
		Customer cust = new Customer("HARSH", "XYZ", "12312312312");
		cust.setUserType("3");
		cust.setUserId(1);
		cust.setEmail("abcd@xyz");
		when(cust_repo.save(cust)).thenReturn(cust);
		Customer result = cust_Service.addCustomer(cust);
		// verify(cust_repo).save(input);
		assertEquals(cust, result);

	}

	@Test
	@Disabled
	public void testDeleteCustomer() throws CustomerNotFoundException {

		Customer cust = new Customer("HARSH", "XYZ", "12312312312");
		cust.setUserType("3");
		cust.setUserId(1);

		Mockito.when(cust_repo.findById(22)).thenThrow(CustomerNotFoundException.class);
		cust_Service.deleteCustomer(cust);
		cust_repo.findById(22);

	}

	@Test
	void testCustomerNotFoundException() {
		Customer customer = new Customer("HARSH", "XYZ", "12312312312");
		customer.setUserType("3");
		customer.setUserId(1);
		Optional<Customer> cust = Optional.of(customer);
		when(cust_repo.findById(1)).thenReturn(cust);
		org.junit.jupiter.api.function.Executable executable = () -> cust_Service.viewCustomer(3);
		assertThrows(CustomerNotFoundException.class, executable);
	}

	@Test
	void testPackageNotFoundException() {
		
		Customer customer = new Customer("HARSH", "XYZ", "12312312312");
		customer.setUserType("3");
		customer.setUserId(1);
		List<Customer>custList= Arrays.asList(customer);
		when(cust_repo.findByPackageId(12)).thenReturn(custList);
		org.junit.jupiter.api.function.Executable executable = () -> cust_Service.viewAllCustomers(5);
		assertThrows(PackageNotFoundException.class, executable);
	}
}