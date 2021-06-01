package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.action.spi.Executable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.g5.tms.entities.Package;
import com.g5.tms.entities.PaymentDetails;
import com.g5.tms.entities.TicketDetails;
import com.g5.tms.entities.Booking;
import com.g5.tms.entities.Bus;
import com.g5.tms.entities.Customer;
import com.g5.tms.entities.Travels;
import com.g5.tms.exceptions.CustomerNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
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
	public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() throws CustomerNotFoundException {
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
	};
}
