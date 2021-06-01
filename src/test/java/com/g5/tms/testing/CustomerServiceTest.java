package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.hibernate.action.spi.Executable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.g5.tms.entities.Customer;
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
      Customer cust =new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
      cust.setUserType("3");
      cust.setUserId(1);
      Optional<Customer> opt=Optional.of(cust) ;
	   Mockito.when(cust_repo.findById(1)).thenReturn(opt);
      Customer test_cust = cust_Service.viewCustomer(1);
      assertEquals(test_cust, cust);
   }
   @Test
   public void testCustomerById() throws CustomerNotFoundException 
   {
	   Optional<Customer>cust=Optional.empty();
	   when(cust_repo.findById(1)).thenReturn(cust);
	   org.junit.jupiter.api.function.Executable executable  = ()-> {
		   assertNotNull(cust_Service.viewCustomer(1));
	   };
	   assertThrows(CustomerNotFoundException.class,executable);
   }
   @Test
   public void testCustomersByPackageId() throws PackageNotFoundException
   {
	   Customer cust1 =new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
	   Customer cust2 =new Customer("HARSH", "XYZ", "12312312312", "xyz@try.com");
   }
}