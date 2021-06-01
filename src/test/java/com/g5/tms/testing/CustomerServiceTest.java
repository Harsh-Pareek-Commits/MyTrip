package com.g5.tms.testing;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Digits;
import static org.mockito.Mockito.when;
import org.hibernate.action.spi.Executable;
import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.g5.tms.entities.Package;
import com.g5.tms.entities.PaymentDetails;
import com.g5.tms.entities.Route;
import com.g5.tms.entities.TicketDetails;
import com.g5.tms.entities.Booking;
import com.g5.tms.entities.Bus;
import com.g5.tms.entities.Customer;
import com.g5.tms.entities.Hotel;
import com.g5.tms.entities.Travels;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.exceptions.RouteNotFoundException;
import com.g5.tms.repository.ICustomerRepository;
import com.g5.tms.service.ICustomerService;
import com.sun.xml.bind.v2.runtime.reflect.Lister.Pack;

@SpringBootTest
@ActiveProfiles("test")

public class CustomerServiceTest {
	@Autowired
	private ICustomerService cust_Service;

	@Autowired
	private ICustomerRepository cust_repo;

	@Test
	public void testCustomerById() throws CustomerNotFoundException {
		Customer cust = new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
		cust.setUserType("3");
		cust.setUserId(1);
		Optional<Customer> opt = Optional.of(cust);
		Mockito.when(cust_repo.findById(1)).thenReturn(opt);
		Customer test_cust = cust_Service.viewCustomer(1);
		assertEquals(cust, test_cust);
	}
	
	@Test
	public void testCustomersByPackageId() throws PackageNotFoundException {
		Customer c1 = new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
		c1.setUserType("3");
		c1.setUserId(1);
		Package p1 = new Package(01, "asds", "asdas", "asds", 1000, null, null);
		LocalDate date = LocalDate.now();
		Booking b1 = new Booking(100, "ds", "jj", "t", date, p1, 1, null, null);
		List<Customer> cust = Arrays.asList(c1);
		Mockito.when(cust_repo.findByPackageId(01)).thenReturn(cust);
		List<Customer> actual_custlist = cust_Service.viewAllCustomers(01);
		assertEquals(cust, actual_custlist);
	}
	
	@Test
	public void testCustomerByRouteId() throws RouteNotFoundException {
		Customer c1 = new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
		c1.setUserType("3");
		c1.setUserId(1);
		LocalDateTime depTime = LocalDateTime.now();
		LocalDateTime arrTime = LocalDateTime.now();
		LocalDate date = LocalDate.now();
		Route r1 = new Route(01, "Hyd", "Banglore", null, depTime, arrTime, date, "HydStop", 2000.00);
		Package p1 = new Package(01, "asds", "asdas", "asds", 1000, r1, null);
		Booking b1 = new Booking(100, "ds", "jj", "t", date, p1, 1, null, null);
		
		List<Customer> cust = Arrays.asList(c1);
		Mockito.when(cust_repo.findByRouteId(01)).thenReturn(cust);
		List<Customer> actual_custList = cust_Service.viewCustomerList(01);
		assertEquals(cust, actual_custList);
				
		
	}
	@Test
	public void testAddCustomer() {
		Customer cust = new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
		cust.setUserType("3");
		cust.setUserId(1);
		when(cust_repo.save(cust)).thenReturn(cust);
		Customer result = cust_Service.addCustomer(cust);
		//verify(cust_repo).save(input);
		assertEquals(cust, result);
		
	}
	
	
	
	@Test
	public void testUpdateCustomer() throws CustomerNotFoundException {
		Customer cust = new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
		cust.setUserType("3");
		cust.setUserId(1);
		Optional<Customer> optional_cust = Optional.of(cust);
		cust_repo.save(cust);
		Customer updatedCust = new Customer("Maya", "XYZ", "12312312312", "xyz@try.com");
		updatedCust.setUserType("3");
		updatedCust.setUserId(1);
		when(cust_repo.findById(1)).thenReturn(optional_cust);
		when(cust_repo.save(updatedCust)).thenReturn(updatedCust);
		Customer outputCustomer = cust_Service.updateCustomer(updatedCust);
		assertEquals(outputCustomer,updatedCust);
	}
	
	
	
	
	@Test
	@Disabled
	public void testDeleteCustomer() throws CustomerNotFoundException {
		  
		/**Customer cust = new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
		cust.setUserType("3");
		cust.setUserId(1);
		//cust_repo.save(cust);
		//cust_repo.delete(cust);
		//when(cust_repo.findById(1)).thenReturn(null);
		
		System.out.println(cust_repo.findById(1));
		assertThatExceptionOfType(CustomerNotFoundException.class);
		System.out.println("deleted");**/
		Customer cust = new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
		cust.setUserType("3");
		cust.setUserId(1);
		Optional<Customer> optional_cust = Optional.of(cust);
		 
	    Mockito.when(cust_repo.findById(22)).thenThrow(CustomerNotFoundException.class);
	    cust_Service.deleteCustomer(cust);
	    //Mockito.verify(cust_repo, times(1)).deleteById(1);
	    cust_repo.findById(22);
	    //assertThatExceptionOfType(CustomerNotFoundException.class);
	    
		}
}
